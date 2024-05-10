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

package neatlogic.framework.cmdb.dto.sync;

import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.cmdb.dto.transaction.TransactionGroupVo;
import neatlogic.framework.cmdb.enums.sync.CollectMode;
import neatlogic.framework.cmdb.enums.sync.ExpressionType;
import neatlogic.framework.cmdb.enums.sync.MatchMode;
import neatlogic.framework.cmdb.enums.sync.SyncStatus;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BasePageVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class SyncCiCollectionVo extends BasePageVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "idList", type = ApiParamType.JSONARRAY)
    private List<Long> idList;
    @EntityField(name = "模型id", type = ApiParamType.LONG)
    private Long ciId;
    @EntityField(name = "模型名称", type = ApiParamType.STRING)
    private String ciLabel;
    @EntityField(name = "模型唯一标识", type = ApiParamType.STRING)
    private String ciName;

    @EntityField(name = "集合名称", type = ApiParamType.STRING)
    private String collectionName;
    @EntityField(name = "集合名称列表", type = ApiParamType.JSONARRAY)
    private List<String> collectionNameList;
    @EntityField(name = "集合类型", type = ApiParamType.STRING)
    private String collectionType;
    @EntityField(name = "父属性", type = ApiParamType.STRING)
    private String parentKey;
    @EntityField(name = "创建时间", type = ApiParamType.LONG)
    private Date fcd;
    @EntityField(name = "创建人", type = ApiParamType.STRING)
    private String fcu;
    @EntityField(name = "异常", type = ApiParamType.STRING)
    private String error;
    @EntityField(name = "修改时间", type = ApiParamType.LONG)
    private Date lcd;
    @EntityField(name = "修改人", type = ApiParamType.STRING)
    private String lcu;
    @EntityField(name = "字段映射配置", type = ApiParamType.JSONARRAY)
    private List<SyncMappingVo> mappingList;
    @EntityField(name = "采集模式", type = ApiParamType.ENUM, member = CollectMode.class)
    private String collectMode;
    @EntityField(name = "采集模式名称", type = ApiParamType.STRING)
    private String collectModeText;
    @EntityField(name = "是否自动提交", type = ApiParamType.INTEGER)
    private Integer isAutoCommit;
    @EntityField(name = "匹配模式", type = ApiParamType.ENUM, member = MatchMode.class)
    private String matchMode;
    @EntityField(name = "匹配模式名称", type = ApiParamType.STRING)
    private String matchModeText;
    @EntityField(name = "唯一属性id列表", type = ApiParamType.JSONARRAY)
    private List<Long> uniqueAttrIdList;
    @EntityField(name = "状态", type = ApiParamType.STRING)
    private String status;
    @EntityField(name = "状态名称", type = ApiParamType.STRING)
    private String statusText;
    @JSONField(serialize = false)
    private TransactionGroupVo transactionGroup;
    @JSONField(serialize = false)
    private SyncAuditVo syncAudit;
    @JSONField(serialize = false)
    private transient SyncPolicyVo syncPolicy;
    @EntityField(name = "允许更新多条", type = ApiParamType.INTEGER)
    private Integer isAllowMultiple;

    @EntityField(name = "策略列表", type = ApiParamType.JSONARRAY)
    private List<SyncPolicyVo> syncPolicyList;
    @EntityField(name = "筛选条件", type = ApiParamType.JSONARRAY)
    private List<SyncConditionVo> conditionList;
    @EntityField(name = "执行次数", type = ApiParamType.INTEGER)
    private int execCount;
    @EntityField(name = "最后采集时间", type = ApiParamType.LONG)
    private Date lastSyncDate;//最后一次同步时间
    @EntityField(name = "说明", type = ApiParamType.STRING)
    private String description;

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public List<SyncConditionVo> getConditionList() {
        return conditionList;
    }

    public void setConditionList(List<SyncConditionVo> conditionList) {
        this.conditionList = conditionList;
    }

    @JSONField(serialize = false)
    public Criteria getCriteria() {
        Criteria finalCriteria = new Criteria();
        if (CollectionUtils.isNotEmpty(this.getConditionList())) {
            List<Criteria> criteriaList = new ArrayList<>();
            for (SyncConditionVo conditionVo : this.getConditionList()) {
                if (StringUtils.isNotBlank(conditionVo.getExpression()) && StringUtils.isNotBlank(conditionVo.getValue()) && StringUtils.isNotBlank(conditionVo.getField())) {

                    if (conditionVo.getExpression().equalsIgnoreCase(ExpressionType.IS.getValue())) {
                        if (!(conditionVo.getFormatValue() instanceof String[])) {
                            Criteria c = Criteria.where(conditionVo.getField());
                            c.is(conditionVo.getFormatValue());
                            criteriaList.add(c);
                        } else {
                            String[] values = (String[]) conditionVo.getFormatValue();
                            List<Criteria> orCriteriaList = new ArrayList<>();
                            for (String v : values) {
                                v = v.trim();
                                Criteria c = Criteria.where(conditionVo.getField());
                                c.is(v);
                                orCriteriaList.add(c);
                            }
                            if (CollectionUtils.isNotEmpty(orCriteriaList)) {
                                finalCriteria.orOperator(orCriteriaList);
                            }
                        }
                    } else if (conditionVo.getExpression().equalsIgnoreCase(ExpressionType.NE.getValue())) {
                        if (!(conditionVo.getFormatValue() instanceof String[])) {
                            Criteria c = Criteria.where(conditionVo.getField());
                            c.ne(conditionVo.getFormatValue());
                            criteriaList.add(c);
                        } else {
                            String[] values = (String[]) conditionVo.getFormatValue();
                            for (String v : values) {
                                v = v.trim();
                                Criteria c = Criteria.where(conditionVo.getField());
                                c.ne(v);
                                criteriaList.add(c);
                            }
                        }
                    } else if (conditionVo.getExpression().equalsIgnoreCase(ExpressionType.IN.getValue())) {
                        if (!(conditionVo.getFormatValue() instanceof String[])) {
                            Criteria c = Criteria.where(conditionVo.getField());
                            Pattern pattern = Pattern.compile("^.*" + conditionVo.getFormatValue() + ".*$", Pattern.CASE_INSENSITIVE);
                            c.regex(pattern);
                            criteriaList.add(c);
                        } else {
                            String[] values = (String[]) conditionVo.getFormatValue();
                            List<Criteria> orCriteriaList = new ArrayList<>();
                            for (String v : values) {
                                v = v.trim();
                                Criteria c = Criteria.where(conditionVo.getField());
                                Pattern pattern = Pattern.compile("^.*" + v + ".*$", Pattern.CASE_INSENSITIVE);
                                c.regex(pattern);
                                orCriteriaList.add(c);
                            }
                            if (CollectionUtils.isNotEmpty(orCriteriaList)) {
                                finalCriteria.orOperator(orCriteriaList);
                            }
                        }
                    } else if (conditionVo.getExpression().equalsIgnoreCase(ExpressionType.NOTIN.getValue())) {
                        if (!(conditionVo.getFormatValue() instanceof String[])) {
                            Criteria c = Criteria.where(conditionVo.getField());
                            Pattern pattern = Pattern.compile("^((?!" + conditionVo.getFormatValue() + ").)*$", Pattern.CASE_INSENSITIVE);
                            c.regex(pattern);
                            criteriaList.add(c);
                        } else {
                            String[] values = (String[]) conditionVo.getFormatValue();
                            for (String v : values) {
                                v = v.trim();
                                Criteria c = Criteria.where(conditionVo.getField());
                                Pattern pattern = Pattern.compile("^((?!" + v + ").)*$", Pattern.CASE_INSENSITIVE);
                                c.regex(pattern);
                                criteriaList.add(c);
                            }
                        }
                    } else if (conditionVo.getExpression().equalsIgnoreCase(ExpressionType.GT.getValue())) {
                        Criteria c = Criteria.where(conditionVo.getField());
                        c.gt(conditionVo.getFormatValue());
                        criteriaList.add(c);
                    } else if (conditionVo.getExpression().equalsIgnoreCase(ExpressionType.LT.getValue())) {
                        Criteria c = Criteria.where(conditionVo.getField());
                        c.lt(conditionVo.getFormatValue());
                        criteriaList.add(c);
                    } else if (conditionVo.getExpression().equalsIgnoreCase(ExpressionType.GTE.getValue())) {
                        Criteria c = Criteria.where(conditionVo.getField());
                        c.gte(conditionVo.getFormatValue());
                        criteriaList.add(c);
                    } else if (conditionVo.getExpression().equalsIgnoreCase(ExpressionType.LTE.getValue())) {
                        Criteria c = Criteria.where(conditionVo.getField());
                        c.lte(conditionVo.getFormatValue());
                        criteriaList.add(c);
                    }

                }
            }
            if (CollectionUtils.isNotEmpty(criteriaList)) {
                finalCriteria.andOperator(criteriaList);
            }
        }
        return finalCriteria;
    }

    public Integer getIsAllowMultiple() {
        return isAllowMultiple;
    }

    public void setIsAllowMultiple(Integer isAllowMultiple) {
        this.isAllowMultiple = isAllowMultiple;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SyncPolicyVo> getSyncPolicyList() {
        return syncPolicyList;
    }

    public void setSyncPolicyList(List<SyncPolicyVo> syncPolicyList) {
        this.syncPolicyList = syncPolicyList;
    }

    public String getStatusText() {
        if (StringUtils.isBlank(statusText) && StringUtils.isNotBlank(status)) {
            statusText = SyncStatus.getText(status);
        }
        return statusText;
    }

    public String getParentKey() {
        return parentKey;
    }

    public void setParentKey(String parentKey) {
        this.parentKey = parentKey;
    }

    public List<String> getCollectionNameList() {
        return collectionNameList;
    }

    public void setCollectionNameList(List<String> collectionNameList) {
        this.collectionNameList = collectionNameList;
    }

    public String getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(String collectionType) {
        this.collectionType = collectionType;
    }

    public List<Long> getUniqueAttrIdList() {
        return uniqueAttrIdList;
    }

    public void setUniqueAttrIdList(List<Long> uniqueAttrIdList) {
        this.uniqueAttrIdList = uniqueAttrIdList;
    }

    public int getExecCount() {
        return execCount;
    }

    public void setExecCount(int execCount) {
        this.execCount = execCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsAutoCommit() {
        return isAutoCommit;
    }

    public void setIsAutoCommit(Integer isAutoCommit) {
        this.isAutoCommit = isAutoCommit;
    }

    public Date getLastSyncDate() {
        return lastSyncDate;
    }

    public void setLastSyncDate(Date lastSyncDate) {
        this.lastSyncDate = lastSyncDate;
    }

    public String getCollectModeText() {
        if (StringUtils.isBlank(collectModeText) && StringUtils.isNotBlank(collectMode)) {
            collectModeText = CollectMode.getText(collectMode);
        }
        return collectModeText;
    }

    public void setCollectModeText(String collectModeText) {
        this.collectModeText = collectModeText;
    }

    public String getCollectMode() {
        return collectMode;
    }

    public void setCollectMode(String collectMode) {
        this.collectMode = collectMode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatchMode() {
        return matchMode;
    }

    public void setMatchMode(String matchMode) {
        this.matchMode = matchMode;
    }

    public String getMatchModeText() {
        if (StringUtils.isBlank(matchModeText) && StringUtils.isNotBlank(matchMode)) {
            matchModeText = MatchMode.getText(matchMode);
        }
        return matchModeText;
    }

    public void setMatchModeText(String matchModeText) {
        this.matchModeText = matchModeText;
    }

    public String getCiLabel() {
        return ciLabel;
    }

    public void setCiLabel(String ciLabel) {
        this.ciLabel = ciLabel;
    }

    public String getCiName() {
        return ciName;
    }

    public void setCiName(String ciName) {
        this.ciName = ciName;
    }

    public Long getCiId() {
        return ciId;
    }

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    public SyncPolicyVo getSyncPolicy() {
        return syncPolicy;
    }

    public void setSyncPolicy(SyncPolicyVo syncPolicy) {
        this.syncPolicy = syncPolicy;
    }

    public TransactionGroupVo getTransactionGroup() {
        return transactionGroup;
    }

    public void setTransactionGroup(TransactionGroupVo transactionGroup) {
        this.transactionGroup = transactionGroup;
    }

    public SyncAuditVo getSyncAudit() {
        return syncAudit;
    }

    public void setSyncAudit(SyncAuditVo syncAudit) {
        this.syncAudit = syncAudit;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public Date getFcd() {
        return fcd;
    }

    public void setFcd(Date fcd) {
        this.fcd = fcd;
    }

    public String getFcu() {
        return fcu;
    }

    public void setFcu(String fcu) {
        this.fcu = fcu;
    }

    public Date getLcd() {
        return lcd;
    }

    public void setLcd(Date lcd) {
        this.lcd = lcd;
    }

    public String getLcu() {
        return lcu;
    }

    public void setLcu(String lcu) {
        this.lcu = lcu;
    }

    public List<SyncMappingVo> getMappingList() {
        return mappingList;
    }

    public void setMappingList(List<SyncMappingVo> mappingList) {
        this.mappingList = mappingList;
    }

    public SyncMappingVo getMappingByAttrId(Long attrId) {
        if (CollectionUtils.isNotEmpty(mappingList)) {
            Optional<SyncMappingVo> op = mappingList.stream().filter(m -> m.getAttrId() != null && m.getAttrId().equals(attrId)).findFirst();
            if (op.isPresent()) {
                return op.get();
            }
        }
        return null;
    }
}
