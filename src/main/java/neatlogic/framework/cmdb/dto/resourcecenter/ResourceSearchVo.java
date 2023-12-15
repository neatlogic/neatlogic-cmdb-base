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

package neatlogic.framework.cmdb.dto.resourcecenter;

import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.asynchronization.threadlocal.UserContext;
import neatlogic.framework.cmdb.resourcecenter.condition.IResourcecenterCondition;
import neatlogic.framework.cmdb.resourcecenter.condition.ResourcecenterConditionFactory;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.constvalue.Expression;
import neatlogic.framework.dto.AuthenticationInfoVo;
import neatlogic.framework.dto.condition.ConditionConfigVo;
import neatlogic.framework.dto.condition.ConditionVo;
import neatlogic.framework.exception.condition.ConditionNotFoundException;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author linbq
 * @since 2021/6/9 20:01
 **/
public class ResourceSearchVo extends ConditionConfigVo {
    private static final long serialVersionUID = 4837890773475493034L;
    @EntityField(name = "类型id", type = ApiParamType.LONG)
    private Long typeId;
    @EntityField(name = "类型id列表", type = ApiParamType.JSONARRAY)
    private List<Long> typeIdList;
    @EntityField(name = "满足权限的类型id列表", type = ApiParamType.JSONARRAY)
    private List<Long> authedTypeIdList;
    @EntityField(name = "IP地址", type = ApiParamType.STRING)
    private String ip;
    @EntityField(name = "端口", type = ApiParamType.INTEGER)
    private String port;
    @EntityField(name = "左编码", type = ApiParamType.INTEGER)
    private Integer lft;
    @EntityField(name = "右编码", type = ApiParamType.INTEGER)
    private Integer rht;
    @EntityField(name = "应用环境id", type = ApiParamType.LONG)
    private Long envId;
    @EntityField(name = "应用模块id", type = ApiParamType.LONG)
    private Long appModuleId;
    @EntityField(name = "应用id", type = ApiParamType.LONG)
    private Long appSystemId;
    @EntityField(name = "协议id列表", type = ApiParamType.JSONARRAY)
    private List<Long> protocolIdList;
    @EntityField(name = "协议列表", type = ApiParamType.JSONARRAY)
    private List<String> protocolList;
    @EntityField(name = "状态id列表", type = ApiParamType.JSONARRAY)
    private List<Long> stateIdList;

    @EntityField(name = "厂商id列表", type = ApiParamType.JSONARRAY)
    private List<Long> vendorIdList;
    @EntityField(name = "应用环境id列表", type = ApiParamType.JSONARRAY)
    private List<Long> envIdList;
    @EntityField(name = "应用系统id列表", type = ApiParamType.JSONARRAY)
    private List<Long> appSystemIdList;
    @EntityField(name = "应用模块id列表", type = ApiParamType.JSONARRAY)
    private List<Long> appModuleIdList;
    @EntityField(name = "标签id列表", type = ApiParamType.JSONARRAY)
    private List<Long> tagIdList;
    @EntityField(name = "资产id列表", type = ApiParamType.JSONARRAY)
    private List<Long> idList;
    @EntityField(name = "ip地址列表", type = ApiParamType.JSONARRAY)
    private List<String> ipList;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "协议", type = ApiParamType.STRING)
    private String protocol;
    @EntityField(name = "账号", type = ApiParamType.STRING)
    private String account;
    @EntityField(name = "巡检状态列表", type = ApiParamType.JSONARRAY)
    private List<String> inspectStatusList;
    @EntityField(name = "巡检作业状态列表", type = ApiParamType.JSONARRAY)
    private List<String> inspectJobPhaseNodeStatusList;
    @EntityField(name = "以IP字段排序", type = ApiParamType.INTEGER)
    private Integer isIpFieldSort;
    @EntityField(name = "以name字段排序", type = ApiParamType.INTEGER)
    private Integer isNameFieldSort;
    @EntityField(name = "批量搜索字段", type = ApiParamType.STRING)
    private String searchField;
    @EntityField(name = "批量搜索值列表", type = ApiParamType.JSONARRAY)
    private List<String> batchSearchList;
    @EntityField(name = "是否存在未配置环境", type = ApiParamType.BOOLEAN)
    private Boolean isExistNoEnv = false;
    @EntityField(name = "是否有cmdb管理权限（模型或配置项管理权限）或 is.resourcecenter.auth = 1", type = ApiParamType.BOOLEAN)
    private Boolean isHasAuth = false;
    @EntityField(name = "校验团体类型", type = ApiParamType.STRING)
    private String cmdbGroupType = "readonly";

    public ResourceSearchVo() {
    }

    public ResourceSearchVo(JSONObject jsonObj) {
        super(jsonObj);
    }
    public ResourceSearchVo(List<Long> tagIdList) {
        this.tagIdList = tagIdList;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public List<Long> getTypeIdList() {
        return typeIdList;
    }

    public void setTypeIdList(List<Long> typeIdList) {
        this.typeIdList = typeIdList;
    }

    public List<Long> getAuthedTypeIdList() {
        return authedTypeIdList;
    }

    public void setAuthedTypeIdList(List<Long> authedTypeIdList) {
        this.authedTypeIdList = authedTypeIdList;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Integer getLft() {
        return lft;
    }

    public void setLft(Integer lft) {
        this.lft = lft;
    }

    public Integer getRht() {
        return rht;
    }

    public void setRht(Integer rht) {
        this.rht = rht;
    }

    public Long getEnvId() {
        return envId;
    }

    public void setEnvId(Long envId) {
        this.envId = envId;
    }

    public Long getAppModuleId() {
        return appModuleId;
    }

    public void setAppModuleId(Long appModuleId) {
        this.appModuleId = appModuleId;
    }

    public Long getAppSystemId() {
        return appSystemId;
    }

    public void setAppSystemId(Long appSystemId) {
        this.appSystemId = appSystemId;
    }

    public List<Long> getProtocolIdList() {
        return protocolIdList;
    }

    public void setProtocolIdList(List<Long> protocolIdList) {
        this.protocolIdList = protocolIdList;
    }

    public List<String> getProtocolList() {
        return protocolList;
    }

    public void setProtocolList(List<String> protocolList) {
        this.protocolList = protocolList;
    }

    public List<Long> getStateIdList() {
        return stateIdList;
    }

    public void setStateIdList(List<Long> stateIdList) {
        this.stateIdList = stateIdList;
    }

    public List<Long> getVendorIdList() {
        return vendorIdList;
    }

    public void setVendorIdList(List<Long> vendorIdList) {
        this.vendorIdList = vendorIdList;
    }

    public List<Long> getEnvIdList() {
        return envIdList;
    }

    public void setEnvIdList(List<Long> envIdList) {
        if (CollectionUtils.isNotEmpty(envIdList) && envIdList.contains(-2L)) {
            isExistNoEnv = true;
        } else {
            this.envIdList = envIdList;
        }
    }

    public List<Long> getAppSystemIdList() {
        return appSystemIdList;
    }

    public void setAppSystemIdList(List<Long> appSystemIdList) {
        this.appSystemIdList = appSystemIdList;
    }

    public List<Long> getAppModuleIdList() {
        return appModuleIdList;
    }

    public void setAppModuleIdList(List<Long> appModuleIdList) {
        this.appModuleIdList = appModuleIdList;
    }

    public List<Long> getTagIdList() {
        return tagIdList;
    }

    public void setTagIdList(List<Long> tagIdList) {
        this.tagIdList = tagIdList;
    }

//    public List<Long> getIdList() {
//        return idList;
//    }
//
//    public void setIdList(List<Long> idList) {
//        this.idList = idList;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIpList() {
        return ipList;
    }

    public void setIpList(List<String> ipList) {
        this.ipList = ipList;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public List<String> getInspectStatusList() {
        return inspectStatusList;
    }

    public void setInspectStatusList(List<String> inspectStatusList) {
        this.inspectStatusList = inspectStatusList;
    }

    public List<String> getInspectJobPhaseNodeStatusList() {
        return inspectJobPhaseNodeStatusList;
    }

    public void setInspectJobPhaseNodeStatusList(List<String> inspectJobPhaseNodeStatusList) {
        this.inspectJobPhaseNodeStatusList = inspectJobPhaseNodeStatusList;
    }

    public Integer getIsIpFieldSort() {
        return isIpFieldSort;
    }

    public void setIsIpFieldSort(Integer isIpFieldSort) {
        this.isIpFieldSort = isIpFieldSort;
    }

    public Integer getIsNameFieldSort() {
        return isNameFieldSort;
    }

    public void setIsNameFieldSort(Integer isNameFieldSort) {
        this.isNameFieldSort = isNameFieldSort;
    }

    public String getSearchField() {
        return searchField;
    }

    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    public List<String> getBatchSearchList() {
        return batchSearchList;
    }

    public void setBatchSearchList(List<String> batchSearchList) {
        this.batchSearchList = batchSearchList;
    }

    public Boolean getExistNoEnv() {
        return isExistNoEnv;
    }

    @Override
    public void buildMyConditionWhereSql(StringBuilder sqlSb, String handler, List<ConditionVo> conditionVoList, int conditionIndex, String searchMode) {
        IResourcecenterCondition resourcecenterCondition = ResourcecenterConditionFactory.getHandler(handler);
        if (resourcecenterCondition == null) {
            throw new ConditionNotFoundException(handler);
        }
        resourcecenterCondition.getSqlConditionWhere(conditionVoList, conditionIndex, sqlSb, searchMode);
    }

    @Override
    public String getBuildNaturalLanguageExpressions(ConditionVo conditionVo) {
        IResourcecenterCondition conditionHandler = ResourcecenterConditionFactory.getHandler(conditionVo.getName());
        if (conditionHandler == null) {
            return StringUtils.EMPTY;
        }
        String textStr = StringUtils.EMPTY;
        Object textObj = conditionHandler.valueConversionText(conditionVo.getValueList(), null);
        if (textObj != null) {
            if (textObj instanceof List) {
                List<String> textList = (List<String>) textObj;
                textStr = String.join("|", textList);
            } else {
                textStr = textObj.toString();
            }
        }
        String label = conditionHandler.getDisplayName();
        String expressionName = Expression.getExpressionName(conditionVo.getExpression());
        return label + " " + expressionName + " " + textStr;
    }

    public AuthenticationInfoVo getAuthenticationInfo() {
        return UserContext.get().getAuthenticationInfoVo();
    }

    public Boolean getIsHasAuth() {
        return isHasAuth;
    }

    public void setIsHasAuth(Boolean isHasAuth) {
        this.isHasAuth = isHasAuth;
    }

    public String getCmdbGroupType() {
        return cmdbGroupType;
    }

    public void setCmdbGroupType(String cmdbGroupType) {
        this.cmdbGroupType = cmdbGroupType;
    }
}
