/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.cientity;

import codedriver.framework.asynchronization.threadlocal.TenantContext;
import codedriver.framework.asynchronization.threadlocal.UserContext;
import codedriver.framework.cmdb.enums.EditModeType;
import codedriver.framework.cmdb.enums.RelDirectionType;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BasePageVo;
import codedriver.framework.elasticsearch.annotation.ESKey;
import codedriver.framework.elasticsearch.constvalue.ESKeyType;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import codedriver.framework.cmdb.dto.ci.AttrVo;
import codedriver.framework.cmdb.dto.ci.CiVo;
import codedriver.framework.cmdb.dto.ci.RelVo;
import codedriver.framework.cmdb.dto.transaction.CiEntityTransactionVo;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CiEntityVo extends BasePageVo {
    @JSONField(serialize = false)
    private transient String keyword;
    @JSONField(serialize = false) // 根据空格拆开关键字
    private transient List<String> keywordList;
    @EntityField(name = "id", type = ApiParamType.LONG)
    @ESKey(type = ESKeyType.PKEY, name = "id")
    private Long id;
    @EntityField(name = "模型id", type = ApiParamType.LONG)
    private Long ciId;
    @EntityField(name = "模型唯一标识", type = ApiParamType.STRING)
    private String ciName;
    @EntityField(name = "模型名称", type = ApiParamType.STRING)
    private String ciLabel;
    @EntityField(name = "模型图标", type = ApiParamType.STRING)
    private String ciIcon;
    @EntityField(name = "配置项名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "模型类型id", type = ApiParamType.LONG)
    private Long typeId;
    @EntityField(name = "模型类型名称", type = ApiParamType.STRING)
    private String typeName;
    @EntityField(name = "创建人", type = ApiParamType.STRING)
    private String fcu;
    @EntityField(name = "创建时间", type = ApiParamType.LONG)
    private Date fcd;
    @EntityField(name = "修改人", type = ApiParamType.STRING)
    private String lcu;
    @EntityField(name = "修改时间", type = ApiParamType.LONG)
    private Date lcd;
    @EntityField(name = "状态", type = ApiParamType.STRING)
    private String status;
    @EntityField(name = "是否锁定编辑", type = ApiParamType.INTEGER)
    private Integer isLocked = 0;
    // @EntityField(name = "属性列表", type = ApiParamType.JSONARRAY)
    @JSONField(serialize = false)
    private transient List<AttrEntityVo> attrEntityList;
    @EntityField(name = "属性对象，以'attr_'+attrId为key", type = ApiParamType.JSONOBJECT)
    private JSONObject attrEntityData;
    // @EntityField(name = "关系列表", type = ApiParamType.JSONARRAY)
    @JSONField(serialize = false)
    private transient List<RelEntityVo> relEntityList;
    @EntityField(name = "关系对象，以'relfrom_'+relId或'relto_'+relId为key", type = ApiParamType.JSONOBJECT)
    private JSONObject relEntityData;
    // @EntityField(name = "属性过滤器列表", type = ApiParamType.JSONARRAY)
    @JSONField(serialize = false)
    private transient List<AttrFilterVo> attrFilterList;
    @JSONField(serialize = false)
    private transient List<RelFilterVo> relFilterList;
    @JSONField(serialize = false)//当前配置项所涉及的所有模型，包括自己
    private transient List<CiVo> ciList;
    @JSONField(serialize = false)//当前配置项包含的所有属性
    private transient List<AttrVo> attrList;
    @JSONField(serialize = false)//当前配置项包含的所有关系
    private transient List<RelVo> relList;
    @JSONField(serialize = false)
    private transient String inputType;// 更新时设置输入方式
    @JSONField(serialize = false)
    private transient String editMode = EditModeType.GLOBAL.getValue();
    @JSONField(serialize = false)
    private transient Long transactionId;
    @JSONField(serialize = false) // 需要返回的属性列表，为空代表返回所有属性
    private transient List<Long> attrIdList;
    @JSONField(serialize = false) // 需要返回的关系列表，为空代表返回所有关系
    private transient List<Long> relIdList;
    @JSONField(serialize = false)
    private transient List<Long> groupIdList;// 查询时使用的群组id
    @JSONField(serialize = false)
    private transient List<Long> idList;// 需要查询的id列表
    @EntityField(name = "当前用户权限情况", type = ApiParamType.JSONOBJECT)
    private Map<String, Boolean> authData;
    @JSONField(serialize = false)//动态属性
    private transient Map<String, Object> attrEntityMap;

    public CiEntityVo() {

    }

    public CiEntityVo(Long id) {
        this.id = id;
    }

    public CiEntityVo(CiEntityTransactionVo ciEntityTransactionVo) {
        this.id = ciEntityTransactionVo.getCiEntityId();
        this.ciId = ciEntityTransactionVo.getCiId();
        this.name = ciEntityTransactionVo.getName();
        this.attrEntityData = ciEntityTransactionVo.getAttrEntityData();
        this.relEntityData = ciEntityTransactionVo.getRelEntityData();

    }

    /**
     * 获取表名
     *
     * @return 表名
     */
    @JSONField(serialize = false)
    public String getCiTableName() {
        return TenantContext.get().getDataDbName() + ".`cmdb_" + this.getCiId() + "`";
    }


    @JSONField(serialize = false)
    @Deprecated
    public RelEntityVo getRelEntityByRelId(Long relId) {
        if (CollectionUtils.isNotEmpty(this.relEntityList)) {
            for (RelEntityVo relEntityVo : this.relEntityList) {
                if (relEntityVo.getRelId().equals(relId)) {
                    return relEntityVo;
                }
            }
        }
        return null;
    }

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCiId() {
        return ciId;
    }

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    public List<CiVo> getCiList() {
        return ciList;
    }

    public void setCiList(List<CiVo> ciList) {
        this.ciList = ciList;
    }

    public String getFcu() {
        if (StringUtils.isBlank(fcu)) {
            return UserContext.get().getUserUuid(true);
        }
        return fcu;
    }

    public void setFcu(String fcu) {
        this.fcu = fcu;
    }

    public Date getFcd() {
        return fcd;
    }

    public void setFcd(Date fcd) {
        this.fcd = fcd;
    }

    public String getLcu() {
        if (StringUtils.isBlank(lcu)) {
            return UserContext.get().getUserUuid(true);
        }
        return lcu;
    }

    public void setLcu(String lcu) {
        this.lcu = lcu;
    }

    public Date getLcd() {
        return lcd;
    }

    public void setLcd(Date lcd) {
        this.lcd = lcd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Integer isLocked) {
        this.isLocked = isLocked;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }


    public List<AttrFilterVo> getAttrFilterList() {
        return attrFilterList;
    }

    /**
     * 添加属性过滤
     *
     * @param attrFilterVo 属性过滤attrEntityData_bak
     */
    public void addAttrFilter(AttrFilterVo attrFilterVo) {
        if (attrFilterList == null) {
            attrFilterList = new ArrayList<>();
        }
        attrFilterList.add(attrFilterVo);
    }

    public void setAttrFilterList(List<AttrFilterVo> attrFilterList) {
        this.attrFilterList = attrFilterList;
    }

    public List<RelFilterVo> getRelFilterList() {
        return relFilterList;
    }

    public void setRelFilterList(List<RelFilterVo> relFilterList) {
        this.relFilterList = relFilterList;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getEditMode() {
        return editMode;
    }

    public void setEditMode(String editMode) {
        this.editMode = editMode;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public List<Long> getAttrIdList() {
        return attrIdList;
    }

    public void setAttrIdList(List<Long> attrIdList) {
        this.attrIdList = attrIdList;
    }

    public List<Long> getRelIdList() {
        return relIdList;
    }

    public void setRelIdList(List<Long> relIdList) {
        this.relIdList = relIdList;
    }

    private static final String regex = "\\{([^}]+?)}";

    /**
     * 添加一个属性数据值
     *
     * @param attrId          属性id
     * @param valueList       属性值
     * @param actualValueList 真实属性值（如果是下拉换成真实的应用值）
     */
    public void addAttrEntityDataValue(Long attrId, JSONArray valueList, JSONArray actualValueList) {
        if (CollectionUtils.isNotEmpty(valueList) && attrEntityData.containsKey("attr_" + attrId)) {
            JSONObject attrObj = attrEntityData.getJSONObject("attr_" + attrId);
            JSONArray currentValueList = attrObj.getJSONArray("valueList");
            JSONArray currentActualValueList = attrObj.getJSONArray("actualValueList");
            valueList.removeAll(currentValueList);
            currentValueList.addAll(valueList);
            actualValueList.removeAll(currentActualValueList);
            currentActualValueList.addAll(actualValueList);
        }
    }


    /**
     * 检查是否有数据项
     *
     * @param attrId 属性id
     * @return true/false
     */
    public boolean hasAttrEntityData(Long attrId) {
        return attrEntityData != null && attrEntityData.containsKey("attr_" + attrId);
    }

    /**
     * 根据属性id获取属性对象
     *
     * @param attrId 属性id
     * @return 包含数据的json
     */
    public AttrEntityVo getAttrEntityByAttrId(Long attrId) {
        if (MapUtils.isNotEmpty(attrEntityData) && attrEntityData.containsKey("attr_" + attrId)) {
            AttrEntityVo attrEntityVo = new AttrEntityVo();
            JSONObject attrEntityObj = attrEntityData.getJSONObject("attr_" + attrId);
            attrEntityVo.setAttrId(attrId);
            attrEntityVo.setAttrType(attrEntityObj.getString("type"));
            attrEntityVo.setAttrName(attrEntityObj.getString("name"));
            attrEntityVo.setAttrLabel(attrEntityObj.getString("label"));
            attrEntityVo.setAttrConfig(attrEntityObj.getJSONObject("config"));

            attrEntityVo.setFromCiId(attrEntityObj.getLong("ciId"));
            attrEntityVo.setToCiId(attrEntityObj.getLong("targetCiId"));
            if (CollectionUtils.isNotEmpty(attrEntityObj.getJSONArray("valueList"))) {
                attrEntityVo.setValueList(attrEntityObj.getJSONArray("valueList"));
            }

            if (CollectionUtils.isNotEmpty(attrEntityObj.getJSONArray("actualValueList"))) {
                attrEntityVo.setActualValueList(attrEntityObj.getJSONArray("actualValueList"));
            }
            return attrEntityVo;
        }
        return null;
    }

    /**
     * 根据属性id获取属性值
     *
     * @param attrId 属性id
     * @return 属性值
     */
    public String getAttrEntityValueByAttrId(Long attrId) {
        if (attrEntityData != null) {
            JSONObject attrObj = attrEntityData.getJSONObject("attr_" + attrId);
            if (attrObj != null && CollectionUtils.isNotEmpty(attrObj.getJSONArray("actualValueList"))) {
                return attrObj.getJSONArray("actualValueList").getString(0);
            }
        }
        return "";
    }

    /**
     * 添加一个属性数据项
     *
     * @param attrId  属性id
     * @param attrObj 属性数据项
     */
    public void addAttrEntityData(Long attrId, JSONObject attrObj) {
        if (attrEntityData == null) {
            attrEntityData = new JSONObject();
        }
        attrEntityData.put("attr_" + attrId, attrObj);
    }

    public JSONObject getAttrEntityData() {
        return attrEntityData;
    }


    public List<AttrEntityVo> getAttrEntityList() {
        attrEntityList = new ArrayList<>();
        if (MapUtils.isNotEmpty(attrEntityData)) {
            for (String key : attrEntityData.keySet()) {
                Long attrId = Long.parseLong(key.replace("attr_", ""));
                attrEntityList.add(this.getAttrEntityByAttrId(attrId));
            }
        }
        return attrEntityList;
    }

    /**
     * 根据关系id和方向获取关系实体列表
     *
     * @param relId     关系id
     * @param direction 方向
     * @return 关系实体列表
     */
    @JSONField(serialize = false)
    public List<RelEntityVo> getRelEntityByRelIdAndDirection(Long relId, String direction) {
        List<RelEntityVo> relEntityList = new ArrayList<>();
        if (MapUtils.isNotEmpty(this.relEntityData) && relEntityData.containsKey("rel" + direction + "_" + relId)) {
            JSONArray relDataList = relEntityData.getJSONObject("rel" + direction + "_" + relId).getJSONArray("valueList");
            if (CollectionUtils.isNotEmpty(relDataList)) {
                for (int i = 0; i < relDataList.size(); i++) {
                    JSONObject relEntityObj = relDataList.getJSONObject(i);
                    RelEntityVo relEntityVo = new RelEntityVo();
                    relEntityVo.setRelId(relId);
                    if (direction.equals(RelDirectionType.FROM.getValue())) {
                        relEntityVo.setToCiId(relEntityObj.getLong("ciId"));
                        relEntityVo.setToCiEntityId(relEntityObj.getLong("ciEntityId"));
                        relEntityVo.setToCiEntityName(relEntityObj.getString("ciEntityName"));
                        relEntityVo.setDirection(RelDirectionType.FROM.getValue());
                        relEntityVo.setFromCiEntityId(this.getId());
                        relEntityVo.setFromCiId(this.getCiId());
                    } else {
                        relEntityVo.setFromCiId(relEntityObj.getLong("ciId"));
                        relEntityVo.setFromCiEntityId(relEntityObj.getLong("ciEntityId"));
                        relEntityVo.setFromCiEntityName(relEntityObj.getString("ciEntityName"));
                        relEntityVo.setDirection(RelDirectionType.TO.getValue());
                        relEntityVo.setToCiEntityId(this.getId());
                        relEntityVo.setToCiId(this.getCiId());
                    }
                    relEntityList.add(relEntityVo);
                }
            }
        }
        return relEntityList;
    }

    public List<RelEntityVo> getRelEntityList() {
        relEntityList = new ArrayList<>();
        if (MapUtils.isNotEmpty(relEntityData)) {
            for (String key : relEntityData.keySet()) {
                Long relId = null;
                String direction = "";
                if (key.startsWith("relfrom_")) {
                    direction = RelDirectionType.FROM.getValue();
                    relId = Long.parseLong(key.replace("relfrom_", ""));
                } else if (key.startsWith("relto_")) {
                    direction = RelDirectionType.TO.getValue();
                    relId = Long.parseLong(key.replace("relto_", ""));
                }
                if (relId != null) {
                    relEntityList.addAll(getRelEntityByRelIdAndDirection(relId, direction));
                }
            }
        }
        return relEntityList;
    }

    /**
     * 添加一个关系数据值
     *
     * @param relId     关系id
     * @param direction 方向
     * @param valueObj  关系值
     */
    public void addRelEntityDataValue(Long relId, String direction, JSONObject valueObj) {
        if (MapUtils.isNotEmpty(valueObj) && relEntityData.containsKey("rel" + direction + "_" + relId)) {
            JSONObject relObj = relEntityData.getJSONObject("rel" + direction + "_" + relId);
            JSONArray valueList = relObj.getJSONArray("valueList");
            boolean isExists = false;
            for (int i = 0; i < valueList.size(); i++) {
                JSONObject vObj = valueList.getJSONObject(i);
                if (vObj.getLong("ciEntityId").equals(valueObj.getLong("ciEntityId"))) {
                    isExists = true;
                    break;
                }
            }
            if (!isExists) {
                valueList.add(valueObj);
            }
        }
    }

    /**
     * 检查是否有数据项
     *
     * @param relId 关系id
     * @return true/false
     */
    public boolean hasRelEntityData(Long relId, String direction) {
        return relEntityData != null && relEntityData.containsKey("rel" + direction + "_" + relId);
    }

    /**
     * 根据关系id获取属性值
     *
     * @param relId 关系id
     * @return 包含数据的json
     */
    public JSONObject getRelEntityDataByRelId(Long relId, String direction) {
        if (relEntityData != null) {
            return relEntityData.getJSONObject("rel" + direction + "_" + relId);
        }
        return null;
    }

    /**
     * 添加一个属性数据项
     *
     * @param relId  关系id
     * @param relObj 关系数据项
     */
    public void addRelEntityData(Long relId, String direction, JSONObject relObj) {
        if (relEntityData == null) {
            relEntityData = new JSONObject();
        }
        relEntityData.put("rel" + direction + "_" + relId, relObj);
    }


    public JSONObject getRelEntityData() {
        return relEntityData;
    }


    public List<Long> getGroupIdList() {
        return groupIdList;
    }

    public void setGroupIdList(List<Long> groupIdList) {
        this.groupIdList = groupIdList;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public Map<String, Boolean> getAuthData() {
        return authData;
    }

    public void setAuthData(Map<String, Boolean> authData) {
        this.authData = authData;
    }

    public String getCiName() {
        return ciName;
    }

    public void setCiName(String ciName) {
        this.ciName = ciName;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof CiEntityVo)) {
            return false;
        }
        final CiEntityVo ciEntityVo = (CiEntityVo) other;
        return getId().equals(ciEntityVo.getId());
    }

    public String getCiIcon() {
        return ciIcon;
    }

    public void setCiIcon(String ciIcon) {
        this.ciIcon = ciIcon;
    }

    public String getCiLabel() {
        return ciLabel;
    }

    public void setCiLabel(String ciLabel) {
        this.ciLabel = ciLabel;
    }

    public Map<String, Object> getAttrEntityMap() {
        return attrEntityMap;
    }

    public void setAttrEntityMap(Map<String, Object> attrEntityMap) {
        this.attrEntityMap = attrEntityMap;
    }

    public List<AttrVo> getAttrList() {
        return attrList;
    }

    public void setAttrList(List<AttrVo> attrList) {
        this.attrList = attrList;
    }

    public List<RelVo> getRelList() {
        return relList;
    }

    public void setRelList(List<RelVo> relList) {
        this.relList = relList;
    }

}