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

package neatlogic.framework.cmdb.dto.transaction;

import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TransactionGroupVo implements Serializable {
    //为了兼容导出数据时忽略版本
    private static final long serialVersionUID = 1L;
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "事务id", type = ApiParamType.JSONARRAY)
    private List<Long> transactionIdList;
    @JSONField(serialize = false)
    private List<TransactionVo> transactionList;
    @JSONField(serialize = false)
    private final Set<Long> excludeCiEntity = new HashSet<>();//记录本次事务组中需要排除的ciEntityId，排除掉的ciEntityId在补充关系事务时不会处理
    @JSONField(serialize = false)
    private boolean needLock = true;//修改配置项是否需要加锁，批量修改时如果设为true很容易导致死锁，某些场景修改范围不一样可以不需要锁

    public void addExclude(Long ciEntityId) {
        excludeCiEntity.add(ciEntityId);
    }

    @JSONField(serialize = false)
    public boolean isExclude(Long ciEntityId) {
        return excludeCiEntity.contains(ciEntityId);
    }

    public boolean isNeedLock() {
        return needLock;
    }

    public void setNeedLock(boolean needLock) {
        this.needLock = needLock;
    }

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public List<TransactionVo> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<TransactionVo> transactionList) {
        this.transactionList = transactionList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTransactionIdList() {
        return transactionIdList;
    }

    public void setTransactionIdList(List<Long> transactionIdList) {
        this.transactionIdList = transactionIdList;
    }

    public void addTransactionId(Long transactionId) {
        if (this.transactionIdList == null) {
            this.transactionIdList = new ArrayList<>();
        }
        if (!this.transactionIdList.contains(transactionId)) {
            this.transactionIdList.add(transactionId);
        }
    }

    public void addTransaction(TransactionVo transactionVo) {
        if (this.transactionList == null) {
            this.transactionList = new ArrayList<>();
        }
        this.transactionList.add(transactionVo);
    }
}
