/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

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
