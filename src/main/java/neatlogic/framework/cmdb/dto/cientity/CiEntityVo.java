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

package neatlogic.framework.cmdb.dto.cientity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.asynchronization.threadlocal.TenantContext;
import neatlogic.framework.asynchronization.threadlocal.UserContext;
import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.cmdb.dto.ci.RelVo;
import neatlogic.framework.cmdb.dto.globalattr.GlobalAttrFilterVo;
import neatlogic.framework.cmdb.dto.globalattr.GlobalAttrItemVo;
import neatlogic.framework.cmdb.dto.transaction.CiEntityTransactionVo;
import neatlogic.framework.cmdb.enums.EditModeType;
import neatlogic.framework.cmdb.enums.RelDirectionType;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BasePageVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.Md5Util;
import neatlogic.framework.util.SnowflakeUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CiEntityVo extends BasePageVo {
    public static final long MAX_RELENTITY_COUNT = 3L;
    public static final long MAX_ATTRENTITY_COUNT = 3L;
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "uuid", type = ApiParamType.STRING)
    private String uuid;//uuid，人行上报需要用到
    @EntityField(name = "模型id", type = ApiParamType.LONG)
    private Long ciId;
    @EntityField(name = "模型id列表", type = ApiParamType.JSONARRAY)
    private List<Long> ciIdList;
    @EntityField(name = "根模型id，主要用在ITSM添加配置项记录根模型ID", type = ApiParamType.LONG)
    private Long rootCiId;
    @JSONField(serialize = false)
    private Long filterCiEntityId;//查询时条件，和idList区别是idList不能允许用户修改，用于框定查询范围，filterCiEntityId允许用户修改
    @JSONField(serialize = false)
    private Long filterCiId;//查询时条件，用于查询抽象模型数据时，可以指定子模型

    @JSONField(serialize = false)
    private List<Long> filterCiIdList;//查询时条件，用于查询抽象模型数据时，可以指定子模型
    @JSONField(serialize = false)
    private String dsl;//查询时条件，使用dsl模式进行查询
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
    @EntityField(name = "操作类型，表单控件中使用", type = ApiParamType.STRING)
    private String actionType;
    @JSONField(serialize = false)
    private Long ciEntityIdStart;
    // @EntityField(name = "属性列表", type = ApiParamType.JSONARRAY)
    @JSONField(serialize = false)
    private List<AttrEntityVo> attrEntityList;

    @JSONField(serialize = false)
    private List<GlobalAttrEntityVo> globalAttrEntityList;
    @EntityField(name = "属性对象，以'attr_'+attrId为key", type = ApiParamType.JSONOBJECT)
    private JSONObject attrEntityData = new JSONObject();

    @EntityField(name = "全局属性，以'global_'+attrId为key", type = ApiParamType.JSONOBJECT)
    private JSONObject globalAttrEntityData = new JSONObject();
    // @EntityField(name = "关系列表", type = ApiParamType.JSONARRAY)
    @JSONField(serialize = false)
    private List<RelEntityVo> relEntityList;
    @EntityField(name = "关系对象，以'relfrom_'+relId或'relto_'+relId为key", type = ApiParamType.JSONOBJECT)
    private JSONObject relEntityData = new JSONObject();
    // @EntityField(name = "属性过滤器列表", type = ApiParamType.JSONARRAY)
    @JSONField(serialize = false)
    private List<AttrFilterVo> attrFilterList;

    @JSONField(serialize = false)
    private List<GlobalAttrFilterVo> globalAttrFilterList;
    @JSONField(serialize = false)
    private List<RelFilterVo> relFilterList;
    @JSONField(serialize = false)//查询关系引用配置项时使用
    private List<RelCiEntityFilterVo> relCiEntityFilterList;
    @JSONField(serialize = false)//查询引用属性配置项时用
    private AttrCiEntityFilterVo attrCiEntityFilter;
    @JSONField(serialize = false)//当前配置项所涉及的所有模型，包括自己
    private List<CiVo> ciList;
    @JSONField(serialize = false)//当前配置项包含的所有属性
    private List<AttrVo> attrList;
    @JSONField(serialize = false)//当前配置项包含的所有关系
    private List<RelVo> relList;
    @JSONField(serialize = false)
    private String inputType;// 更新时设置输入方式
    @JSONField(serialize = false)
    private Long attrId;// 关系id（通过引用配置项查询引用属性时使用）
    @JSONField(serialize = false)
    private Long fromCiEntityId;//引用配置项id（通过引用配置项查询引用属性时使用）
    @JSONField(serialize = false)
    private String editMode = EditModeType.GLOBAL.getValue();
    @JSONField(serialize = false)
    private Long transactionId;
    @JSONField(serialize = false) // 需要返回的属性列表，注意：为空代表返回所有属性！！！
    private List<Long> attrIdList;
    @JSONField(serialize = false)// 需要返回的全局属性列表，注意：为空代表返回所有全局属性！！！
    private List<Long> globalAttrIdList;
    @JSONField(serialize = false) // 需要返回的关系列表，注意：为空代表返回所有关系！！！
    private List<Long> relIdList;
    @JSONField(serialize = false)//搜索时需要排除的relId
    private List<Long> excludeRelIdList;
    @JSONField(serialize = false)
    private List<Long> groupIdList;// 查询时使用的群组id
    @JSONField(serialize = false)
    private List<Long> idList;// 需要查询的id列表
    @JSONField(serialize = false)
    private boolean globalAttrStrictMode;//全局属性严格模式，严格模式下不返回没有全局属性的配置项，只用在配置项搜索
    @EntityField(name = "当前用户权限情况", type = ApiParamType.JSONOBJECT)
    private Map<String, Boolean> authData;
    @JSONField(serialize = false)//动态属性
    private Map<String, Object> attrEntityMap;
    @EntityField(name = "是否抽象模型", type = ApiParamType.INTEGER)
    private int isVirtual = 0;
    @EntityField(name = "最大展示关系数量", type = ApiParamType.INTEGER)
    private Long maxRelEntityCount = MAX_RELENTITY_COUNT;//限制查询时最多返回多少关系
    @EntityField(name = "最大展示引用属性数量", type = ApiParamType.INTEGER)
    private Long maxAttrEntityCount = MAX_ATTRENTITY_COUNT;//限制查询是最多返回多少引用属性
    @EntityField(name = "修改备注", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "巡检时间", type = ApiParamType.LONG)
    private Date inspectTime;
    @EntityField(name = "过期时间", type = ApiParamType.LONG)
    private Date expiredTime;
    @EntityField(name = "巡检状态", type = ApiParamType.STRING)
    private String inspectStatus;
    @EntityField(name = "监控时间", type = ApiParamType.LONG)
    private Date monitorTime;
    @EntityField(name = "监控状态", type = ApiParamType.STRING)
    private String monitorStatus;
    @EntityField(name = "更新时间，用于检查数据是否老化", type = ApiParamType.LONG)
    private Date renewTime;
    @EntityField(name = "排序", type = ApiParamType.JSONARRAY)
    private List<SortVo> sortList;
    @JSONField(serialize = false)
    private Boolean limitRelEntity;//限制关系数量，避免查询返回的结果集太大
    @JSONField(serialize = false)
    private Boolean limitAttrEntity;//限制引用属性数量，避免查询返回的结果集太大
    @EntityField(name = "过期天数", type = ApiParamType.INTEGER)
    private Integer expiredDay;
    @EntityField(name = "账号", type = ApiParamType.STRING)
    private String account;

    public CiEntityVo() {

    }


    public CiEntityVo(Long id) {
        this.id = id;
    }

    public CiEntityVo(Long ciId, Long id) {
        this.ciId = ciId;
        this.id = id;
    }

    public List<Long> getFilterCiIdList() {
        return filterCiIdList;
    }

    public void setFilterCiIdList(List<Long> filterCiIdList) {
        this.filterCiIdList = filterCiIdList;
    }

    public CiEntityVo(Long ciId, String name) {
        this.ciId = ciId;
        this.name = name;
    }

    public List<Long> getCiIdList() {
        return ciIdList;
    }

    public void setCiIdList(List<Long> ciIdList) {
        this.ciIdList = ciIdList;
    }

    public List<SortVo> getSortList() {
        return sortList;
    }

    public void setSortList(List<SortVo> sortList) {
        this.sortList = sortList;
    }

    public Date getRenewTime() {
        return renewTime;
    }

    public void setRenewTime(Date renewTime) {
        this.renewTime = renewTime;
    }

    public Boolean isLimitRelEntity() {
        return limitRelEntity;
    }

    public boolean isGlobalAttrStrictMode() {
        return globalAttrStrictMode;
    }

    public void setGlobalAttrStrictMode(boolean globalAttrStrictMode) {
        this.globalAttrStrictMode = globalAttrStrictMode;
    }

    public List<Long> getExcludeRelIdList() {
        return excludeRelIdList;
    }

    public void setExcludeRelIdList(List<Long> excludeRelIdList) {
        this.excludeRelIdList = excludeRelIdList;
    }

    public void setLimitRelEntity(Boolean limitRelEntity) {
        this.limitRelEntity = limitRelEntity;
    }

    public Boolean isLimitAttrEntity() {
        return limitAttrEntity;
    }

    public void setLimitAttrEntity(Boolean limitAttrEntity) {
        this.limitAttrEntity = limitAttrEntity;
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public Long getFromCiEntityId() {
        return fromCiEntityId;
    }

    public void setFromCiEntityId(Long fromCiEntityId) {
        this.fromCiEntityId = fromCiEntityId;
    }

    public String getDsl() {
        return dsl;
    }

    public void setDsl(String dsl) {
        this.dsl = dsl;
    }

    public Long getFilterCiEntityId() {
        return filterCiEntityId;
    }

    public void setFilterCiEntityId(Long filterCiEntityId) {
        this.filterCiEntityId = filterCiEntityId;
    }

    public Long getRootCiId() {
        return rootCiId;
    }

    public void setRootCiId(Long rootCiId) {
        this.rootCiId = rootCiId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JSONObject getGlobalAttrEntityData() {
        return globalAttrEntityData;
    }

    public void setGlobalAttrEntityData(JSONObject globalAttrEntityData) {
        this.globalAttrEntityData = globalAttrEntityData;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public Long getMaxRelEntityCount() {
        return maxRelEntityCount;
    }

    public void setMaxRelEntityCount(Long maxRelEntityCount) {
        this.maxRelEntityCount = maxRelEntityCount;
    }

    public Long getMaxAttrEntityCount() {
        return maxAttrEntityCount;
    }

    public void setMaxAttrEntityCount(Long maxAttrEntityCount) {
        this.maxAttrEntityCount = maxAttrEntityCount;
    }

    public List<RelCiEntityFilterVo> getRelCiEntityFilterList() {
        return relCiEntityFilterList;
    }

    public void setRelCiEntityFilterList(List<RelCiEntityFilterVo> relCiEntityFilterList) {
        this.relCiEntityFilterList = relCiEntityFilterList;
    }

    public AttrCiEntityFilterVo getAttrCiEntityFilter() {
        if (attrCiEntityFilter == null && attrId != null && fromCiEntityId != null) {
            attrCiEntityFilter = new AttrCiEntityFilterVo(attrId, fromCiEntityId);
        }
        return attrCiEntityFilter;
    }

    private void setAttrCiEntityFilter(AttrCiEntityFilterVo attrCiEntityFilter) {
        this.attrCiEntityFilter = attrCiEntityFilter;
    }

    public String getUuid() {
        if (StringUtils.isBlank(uuid)) {
            uuid = Md5Util.encryptMD5(this.getId().toString());
        }
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public CiEntityVo(CiEntityTransactionVo ciEntityTransactionVo) {
        this.id = ciEntityTransactionVo.getCiEntityId();
        this.uuid = ciEntityTransactionVo.getCiEntityUuid();
        this.ciId = ciEntityTransactionVo.getCiId();
        this.name = ciEntityTransactionVo.getName();
        this.attrEntityData = ciEntityTransactionVo.getAttrEntityData();
        this.relEntityData = ciEntityTransactionVo.getRelEntityData();
        this.globalAttrEntityData = ciEntityTransactionVo.getGlobalAttrEntityData();
        this.description = ciEntityTransactionVo.getDescription();
    }

    public Long getFilterCiId() {
        return filterCiId;
    }

    public void setFilterCiId(Long filterCiId) {
        this.filterCiId = filterCiId;
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
    public List<RelEntityVo> getRelEntityByRelId(Long relId) {
        List<RelEntityVo> relEntityList = new ArrayList<>();
        relEntityList.addAll(getRelEntityByRelIdAndDirection(relId, RelDirectionType.FROM.getValue()));
        relEntityList.addAll(getRelEntityByRelIdAndDirection(relId, RelDirectionType.TO.getValue()));
        return relEntityList;
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

    public Long getCiEntityIdStart() {
        return ciEntityIdStart;
    }

    public void setCiEntityIdStart(Long ciEntityIdStart) {
        this.ciEntityIdStart = ciEntityIdStart;
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

    public List<GlobalAttrFilterVo> getGlobalAttrFilterList() {
        return globalAttrFilterList;
    }

    public void setGlobalAttrFilterList(List<GlobalAttrFilterVo> globalAttrFilterList) {
        this.globalAttrFilterList = globalAttrFilterList;
    }

    public List<AttrFilterVo> getAttrFilterList() {
        return attrFilterList;
    }

    //用于打印日志
    public String getAttrFilterString() {
        if (CollectionUtils.isNotEmpty(attrFilterList)) {
            return attrFilterList.stream().map(AttrFilterVo::toString)
                    .collect(Collectors.joining("; "));
        }
        return "";
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

    public List<Long> getGlobalAttrIdList() {
        return globalAttrIdList;
    }

    public void setGlobalAttrIdList(List<Long> globalAttrIdList) {
        this.globalAttrIdList = globalAttrIdList;
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
     * 添加一个属性数据值
     *
     * @param attrId    属性id
     * @param valueList 属性值
     */
    public void addAttrEntityDataValue(Long attrId, JSONArray valueList) {
        if (CollectionUtils.isNotEmpty(valueList) && attrEntityData.containsKey("attr_" + attrId)) {
            JSONObject attrObj = attrEntityData.getJSONObject("attr_" + attrId);
            JSONArray currentValueList = attrObj.getJSONArray("valueList");
            valueList.removeAll(currentValueList);
            currentValueList.addAll(valueList);
        }
    }

    /**
     * 添加一个属性数据值
     *
     * @param attrId    属性id
     * @param valueList 属性值
     */
    public void addAttrEntityDataValue(Long attrId, Object valueList) {
        if (valueList != null) {
            if (valueList instanceof JSONArray) {
                addAttrEntityDataValue(attrId, (JSONArray) valueList);
            } else {
                addAttrEntityDataValue(attrId, new JSONArray() {{
                    this.add(valueList);
                }});
            }
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
     * 根据属性id获取全局属性对象
     *
     * @param attrId 属性id
     * @return 包含数据的json
     */
    public GlobalAttrEntityVo getGlobalAttrEntityByAttrId(Long attrId) {
        if (MapUtils.isNotEmpty(globalAttrEntityData) && globalAttrEntityData.containsKey("global_" + attrId)) {
            GlobalAttrEntityVo attrEntityVo = new GlobalAttrEntityVo();
            JSONObject attrEntityObj = globalAttrEntityData.getJSONObject("global_" + attrId);
            attrEntityVo.setAttrId(attrId);
            attrEntityVo.setAttrName(attrEntityObj.getString("name"));
            attrEntityVo.setAttrLabel(attrEntityObj.getString("label"));
            JSONArray valueObjList = attrEntityObj.getJSONArray("valueList");
            if (CollectionUtils.isNotEmpty(valueObjList)) {
                List<GlobalAttrItemVo> valueList = new ArrayList<>();
                for (int i = 0; i < valueObjList.size(); i++) {
                    GlobalAttrItemVo globalAttrItemVo = JSONObject.toJavaObject(valueObjList.getJSONObject(i), GlobalAttrItemVo.class);
                    if (globalAttrItemVo.getId() != null) {
                        valueList.add(globalAttrItemVo);
                    }
                }
                if (CollectionUtils.isNotEmpty(valueList)) {
                    attrEntityVo.setValueList(valueList);
                }
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

    public void addGlobalAttrData(Long attrId, JSONObject attrObj) {
        if (globalAttrEntityData == null) {
            globalAttrEntityData = new JSONObject();
        }
        globalAttrEntityData.put("global_" + attrId, attrObj);
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

    public List<GlobalAttrEntityVo> getGlobalAttrEntityList() {
        globalAttrEntityList = new ArrayList<>();
        if (MapUtils.isNotEmpty(globalAttrEntityData)) {
            for (String key : globalAttrEntityData.keySet()) {
                Long attrId = Long.parseLong(key.replace("global_", ""));
                globalAttrEntityList.add(this.getGlobalAttrEntityByAttrId(attrId));
            }
        }
        return globalAttrEntityList;
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
            JSONObject relEntityDataObj = relEntityData.getJSONObject("rel" + direction + "_" + relId);
            JSONArray relDataList = relEntityDataObj.getJSONArray("valueList");
            if (CollectionUtils.isNotEmpty(relDataList)) {
                for (int i = 0; i < relDataList.size(); i++) {
                    JSONObject relEntityObj = relDataList.getJSONObject(i);
                    RelEntityVo relEntityVo = new RelEntityVo();
                    relEntityVo.setRelId(relId);
                    relEntityVo.setRelLabel(relEntityDataObj.getString("label"));
                    if (direction.equals(RelDirectionType.FROM.getValue())) {
                        relEntityVo.setToCiId(relEntityObj.getLong("ciId"));
                        relEntityVo.setToCiName(relEntityDataObj.getString("ciName"));
                        relEntityVo.setToCiLabel(relEntityDataObj.getString("ciLabel"));
                        relEntityVo.setToCiEntityId(relEntityObj.getLong("ciEntityId"));
                        relEntityVo.setToCiEntityName(relEntityObj.getString("ciEntityName"));
                        relEntityVo.setDirection(RelDirectionType.FROM.getValue());
                        relEntityVo.setFromCiEntityId(this.getId());
                        relEntityVo.setFromCiId(this.getCiId());
                    } else {
                        relEntityVo.setFromCiId(relEntityObj.getLong("ciId"));
                        relEntityVo.setFromCiName(relEntityDataObj.getString("ciName"));
                        relEntityVo.setFromCiLabel(relEntityDataObj.getString("ciLabel"));
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
        if (this.filterCiEntityId != null) {
            if (idList == null) {
                idList = new ArrayList<>();
            }
            idList.add(this.filterCiEntityId);
        }
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public void addId(Long id) {
        if (idList == null) {
            idList = new ArrayList<>();
        }
        idList.add(id);
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

    public int getIsVirtual() {
        return isVirtual;
    }

    public void setIsVirtual(int isVirtual) {
        this.isVirtual = isVirtual;
    }

    /**
     * 根据关系id、方向和目标删除关系
     *
     * @param relId     关系id
     * @param direction 方向
     * @param targetId  目标id
     */
    public void removeRelEntityData(Long relId, String direction, Long targetId) {
        if (relEntityData.containsKey("rel" + direction + "_" + relId) && relEntityData.getJSONObject("rel" + direction + "_" + relId).containsKey("valueList")) {
            JSONArray relList = relEntityData.getJSONObject("rel" + direction + "_" + relId).getJSONArray("valueList");
            if (CollectionUtils.isNotEmpty(relList)) {
                List<Integer> removeList = new ArrayList<>();
                for (int i = 0; i < relList.size(); i++) {
                    JSONObject relObj = relList.getJSONObject(i);
                    //如果是新增加目标则不会有ciEntityId,所以必须要判断ciEntityId是否为空
                    if (relObj.containsKey("ciEntityId") && relObj.getLong("ciEntityId").equals(targetId)) {
                        removeList.add(i);
                    }
                }
                for (int index : removeList) {
                    relList.remove(index);
                }
                if (CollectionUtils.isEmpty(relList)) {
                    relEntityData.remove("rel" + direction + "_" + relId);
                }
            }
        }
    }

    public Date getInspectTime() {
        return inspectTime;
    }

    public void setInspectTime(Date inspectTime) {
        this.inspectTime = inspectTime;
    }

    public String getInspectStatus() {
        return inspectStatus;
    }

    public void setInspectStatus(String inspectStatus) {
        this.inspectStatus = inspectStatus;
    }

    public Date getMonitorTime() {
        return monitorTime;
    }

    public void setMonitorTime(Date monitorTime) {
        this.monitorTime = monitorTime;
    }

    public String getMonitorStatus() {
        return monitorStatus;
    }

    public void setMonitorStatus(String monitorStatus) {
        this.monitorStatus = monitorStatus;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Integer getExpiredDay() {
        return expiredDay;
    }

    public void setExpiredDay(Integer expiredDay) {
        this.expiredDay = expiredDay;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
