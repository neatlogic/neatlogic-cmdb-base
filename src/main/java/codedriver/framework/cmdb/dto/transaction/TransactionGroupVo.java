/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.transaction;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
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
    private transient List<TransactionVo> transactionList;
    @JSONField(serialize = false)
    private final transient Set<Long> excludeCiEntity = new HashSet<>();//记录本次事务组中需要排除的ciEntityId，排除掉的ciEntityId在补充关系事务时不会处理

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
}
