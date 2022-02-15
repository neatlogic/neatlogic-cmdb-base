/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.sync;

import codedriver.framework.cmdb.dto.transaction.TransactionGroupVo;
import codedriver.framework.cmdb.enums.sync.CollectMode;
import codedriver.framework.cmdb.enums.sync.MatchMode;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BasePageVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class SyncCiCollectionVo extends BasePageVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
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
    @JSONField(serialize = false)
    private TransactionGroupVo transactionGroup;
    @JSONField(serialize = false)
    private SyncAuditVo syncAudit;
    @JSONField(serialize = false)
    private SyncPolicyVo syncPolicy;
    @EntityField(name = "执行次数", type = ApiParamType.INTEGER)
    private int execCount;
    @EntityField(name = "最后采集时间", type = ApiParamType.LONG)
    private Date lastSyncDate;//最后一次同步时间
    @EntityField(name = "说明", type = ApiParamType.STRING)
    private String description;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
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
