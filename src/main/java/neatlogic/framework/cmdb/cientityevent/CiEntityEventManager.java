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

import neatlogic.framework.asynchronization.taskmanager.AsyncTaskManager;
import neatlogic.framework.cmdb.dto.cientity.CiEntityVo;
import neatlogic.framework.transaction.core.AfterTransactionJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CiEntityEventManager {
    private static final Logger logger = LoggerFactory.getLogger(CiEntityEventManager.class);
    private static final int MAX_WORKERS = 3;
    private static AsyncTaskManager<CiEntityEventJob> manager;

    private CiEntityEventManager() {
    }

    /**
     * 注册配置项事件，在当前事务提交后提交到统一队列，避免批量操作直接放大并发。
     */
    public static void doEvent(CiEntityEventType eventType, CiEntityVo ciEntityVo) {
        if (eventType == null || ciEntityVo == null) {
            return;
        }
        AfterTransactionJob<CiEntityVo> job = new AfterTransactionJob<>("CIENTITY-EVENT-" + eventType.getValue().toUpperCase());
        job.execute(ciEntityVo, eventCiEntityVo -> getManager().submitTask(new CiEntityEventJob(eventType, eventCiEntityVo)));
    }

    /**
     * 获取配置项事件任务管理器，固定单 worker 串行消费事件。
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
    private static void executeHandler(CiEntityEventType eventType, CiEntityVo ciEntityVo) {
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
                logger.error("CiEntity event handler failed, eventType: {}, handler: {}, ciEntityId: {}, ciId: {}",
                        eventType.getValue(), handler.getClass().getName(), ciEntityVo.getId(), ciEntityVo.getCiId(), e);
            }
        }
    }

    private static class CiEntityEventJob {
        private final CiEntityEventType eventType;
        private final CiEntityVo ciEntityVo;

        /**
         * 创建配置项事件任务，任务进入 AsyncTaskManager 后再执行具体处理器。
         */
        private CiEntityEventJob(CiEntityEventType eventType, CiEntityVo ciEntityVo) {
            this.eventType = eventType;
            this.ciEntityVo = ciEntityVo;
        }

        /**
         * 执行单个配置项事件，内部仍按处理器排序顺序分发。
         */
        private void execute() {
            executeHandler(eventType, ciEntityVo);
        }
    }
}
