/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package neatlogic.framework.cmdb.dto.transaction;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TransactionGroupVo implements Serializable {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "事务id", type = ApiParamType.JSONARRAY)
    private List<Long> transactionIdList;
    @JSONField(serialize = false)
    private List<TransactionVo> transactionList;
    @JSONField(serialize = false)
    private final Set<Long> excludeCiEntity = new HashSet<>();//记录本次事务组中需要排除的ciEntityId，排除掉的ciEntityId在补充关系事务时不会处理

    public void addExclude(Long ciEntityId) {
        excludeCiEntity.add(ciEntityId);
    }

    @JSONField(serialize = false)
    public boolean isExclude(Long ciEntityId) {
        return excludeCiEntity.contains(ciEntityId);
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
