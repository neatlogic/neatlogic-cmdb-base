/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.cmdb.cientityevent;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.asynchronization.taskmanager.AsyncTaskManager;
import neatlogic.framework.cmdb.dao.mapper.cientity.CiEntityEventMapper;
import neatlogic.framework.cmdb.dto.cientity.CiEntityEventVo;
import neatlogic.framework.cmdb.dto.cientity.CiEntityVo;
import neatlogic.framework.common.config.Config;
import neatlogic.framework.transaction.core.AfterTransactionJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiEntityEventManager {
    private static final Logger logger = LoggerFactory.getLogger(CiEntityEventManager.class);
    private static final int MAX_WORKERS = 3;
    private static final int MAX_RETRY_COUNT = 10;
    private static AsyncTaskManager<CiEntityEventJob> manager;
    private static CiEntityEventMapper ciEntityEventMapper;

    @Autowired
    public CiEntityEventManager(CiEntityEventMapper _ciEntityEventMapper) {
        ciEntityEventMapper = _ciEntityEventMapper;
    }

    /**
     * 注册配置项事件，先随业务事务持久化，提交后再进入统一队列。
     */
    public static void doEvent(CiEntityEventType eventType, CiEntityVo ciEntityVo) {
        if (eventType == null || ciEntityVo == null) {
            return;
        }
        if (ciEntityEventMapper == null) {
            logger.error("CiEntity event mapper is not initialized, eventType: {}, ciEntityId: {}, ciId: {}",
                    eventType.getValue(), ciEntityVo.getId(), ciEntityVo.getCiId());
            return;
        }
        CiEntityEventVo eventVo = buildEventVo(eventType, ciEntityVo);
        ciEntityEventMapper.insertCiEntityEvent(eventVo);
        AfterTransactionJob<Long> job = new AfterTransactionJob<>("CIENTITY-EVENT-" + eventType.getValue().toUpperCase());
        job.execute(eventVo.getId(), CiEntityEventManager::submitEvent);
    }

    /**
     * 提交已持久化事件到内存队列，供启动恢复复用。
     */
    public static void submitEvent(Long eventId) {
        if (eventId == null) {
            return;
        }
        getManager().submitTask(new CiEntityEventJob(eventId));
    }

    /**
     * 生成持久化事件快照，恢复时按当时的配置项数据执行处理器。
     */
    private static CiEntityEventVo buildEventVo(CiEntityEventType eventType, CiEntityVo ciEntityVo) {
        JSONObject payload = (JSONObject) JSON.toJSON(ciEntityVo);
        payload.put("attrEntityData", ciEntityVo.getAttrEntityData());
        payload.put("globalAttrEntityData", ciEntityVo.getGlobalAttrEntityData());
        payload.put("relEntityData", ciEntityVo.getRelEntityData());
        CiEntityEventVo eventVo = new CiEntityEventVo();
        eventVo.setEventType(eventType.getValue());
        eventVo.setCiEntityId(ciEntityVo.getId());
        eventVo.setCiId(ciEntityVo.getCiId());
        eventVo.setStatus(CiEntityEventStatus.PENDING.getValue());
        eventVo.setServerId(Config.SCHEDULE_SERVER_ID);
        eventVo.setPayload(payload.toJSONString());
        return eventVo;
    }

    /**
     * 获取配置项事件任务管理器，统一限制 worker 数量消费事件。
     */
    private static synchronized AsyncTaskManager<CiEntityEventJob> getManager() {
        if (manager == null) {
            manager = AsyncTaskManager.getInstance("CIENTITY-EVENT-HANDLER", MAX_WORKERS, CiEntityEventJob::execute);
        }
        return manager;
    }

    /**
     * 按事件类型分发到处理器，单个处理器异常不影响后续处理器。
     */
    private static boolean executeHandler(CiEntityEventType eventType, CiEntityVo ciEntityVo) {
        boolean isSuccess = true;
        for (ICiEntityEventHandler handler : CiEntityEventFactory.getHandlerList()) {
            try {
                if (eventType == CiEntityEventType.CREATE) {
                    handler.afterCreate(ciEntityVo);
                } else if (eventType == CiEntityEventType.UPDATE) {
                    handler.afterUpdate(ciEntityVo);
                } else if (eventType == CiEntityEventType.DELETE) {
                    handler.afterDelete(ciEntityVo);
                } else if (eventType == CiEntityEventType.RECOVER) {
                    handler.afterRecover(ciEntityVo);
                }
            } catch (Exception e) {
                isSuccess = false;
                logger.error("CiEntity event handler failed, eventType: {}, handler: {}, ciEntityId: {}, ciId: {}",
                        eventType.getValue(), handler.getClass().getName(), ciEntityVo.getId(), ciEntityVo.getCiId(), e);
            }
        }
        return isSuccess;
    }

    private static class CiEntityEventJob {
        private final Long eventId;

        /**
         * 创建配置项事件任务，任务进入 AsyncTaskManager 后根据事件id读取持久化快照。
         */
        private CiEntityEventJob(Long eventId) {
            this.eventId = eventId;
        }

        /**
         * 执行单个配置项事件，正常走完后删除队列记录，避免持久化表无限增长。
         */
        private void execute() {
            boolean isClaimed = false;
            boolean isSuccess = false;
            try {
                CiEntityEventVo eventVo = ciEntityEventMapper.getCiEntityEventById(eventId);
                if (eventVo == null) {
                    return;
                }
                if (eventVo.getRetryCount() != null && eventVo.getRetryCount() >= MAX_RETRY_COUNT) {
                    logger.warn("CiEntity event retry count exceeded, eventId: {}, eventType: {}, ciEntityId: {}, ciId: {}, retryCount: {}",
                            eventId, eventVo.getEventType(), eventVo.getCiEntityId(), eventVo.getCiId(), eventVo.getRetryCount());
                    ciEntityEventMapper.deleteCiEntityEventById(eventId);
                    return;
                }
                isClaimed = ciEntityEventMapper.updatePendingCiEntityEventToRunning(eventId, Config.SCHEDULE_SERVER_ID) > 0;
                if (!isClaimed) {
                    return;
                }
                CiEntityEventType eventType = CiEntityEventType.getByValue(eventVo.getEventType());
                if (eventType == null) {
                    logger.error("CiEntity event type is invalid, eventId: {}, eventType: {}", eventId, eventVo.getEventType());
                    return;
                }
                CiEntityVo ciEntityVo = JSON.parseObject(eventVo.getPayload(), CiEntityVo.class);
                isSuccess = executeHandler(eventType, ciEntityVo);
            } catch (Exception e) {
                logger.error("CiEntity event execute failed, eventId: {}", eventId, e);
            } finally {
                if (isClaimed && isSuccess && !Thread.currentThread().isInterrupted()) {
                    ciEntityEventMapper.deleteCiEntityEventById(eventId);
                }
            }
        }
    }
}
