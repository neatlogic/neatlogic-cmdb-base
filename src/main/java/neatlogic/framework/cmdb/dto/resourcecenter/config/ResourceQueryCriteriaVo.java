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

package neatlogic.framework.cmdb.dto.resourcecenter.config;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.cmdb.dto.resourcecenter.ResourceConditionConfigVo;
import neatlogic.framework.cmdb.dto.resourcecenter.ResourceSearchVo;
import neatlogic.framework.cmdb.dto.resourcecenter.ResourceVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.dto.AuthenticationInfoVo;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class ResourceQueryCriteriaVo {
    private String keyword;
    private List<String> keywordList;
    @EntityField(name = "协议id列表", type = ApiParamType.JSONARRAY)
    private List<Long> protocolIdList;
    @EntityField(name = "标签id列表", type = ApiParamType.JSONARRAY)
    private List<Long> tagIdList;
    @EntityField(name = "标签匹配模式", type = ApiParamType.STRING)
    private String tagMatchMode;
    @EntityField(name = "巡检作业状态列表", type = ApiParamType.JSONARRAY)
    private List<String> inspectJobPhaseNodeStatusList;
    @EntityField(name = "是否有cmdb管理权限（模型或配置项管理权限）或 is.resourcecenter.auth = 1", type = ApiParamType.BOOLEAN)
    private Boolean isHasAuth;
    @EntityField(name = "校验团体类型", type = ApiParamType.STRING)
    private String cmdbGroupType;
    @EntityField(name = "批量搜索值列表", type = ApiParamType.JSONARRAY)
    private List<String> batchSearchList;
    @EntityField(name = "批量搜索字段", type = ApiParamType.STRING)
    private String searchField;
    @EntityField(name = "类型id列表", type = ApiParamType.JSONARRAY)
    private List<Long> typeIdList;
    @EntityField(name = "满足权限的类型id列表", type = ApiParamType.JSONARRAY)
    private List<Long> authedTypeIdList;
    @EntityField(name = "状态id列表", type = ApiParamType.JSONARRAY)
    private List<Long> stateIdList;
    @EntityField(name = "厂商id列表", type = ApiParamType.JSONARRAY)
    private List<Long> vendorIdList;
    @EntityField(name = "应用环境id列表", type = ApiParamType.JSONARRAY)
    private List<Long> envIdList;
    @EntityField(name = "是否存在未配置环境", type = ApiParamType.BOOLEAN)
    private Boolean isExistNoEnv;
    @EntityField(name = "应用系统id列表", type = ApiParamType.JSONARRAY)
    private List<Long> appSystemIdList;
    @EntityField(name = "应用模块id列表", type = ApiParamType.JSONARRAY)
    private List<Long> appModuleIdList;
    @EntityField(name = "默认值", type = ApiParamType.JSONARRAY)
    private JSONArray defaultValue;
    @EntityField(name = "资产id列表", type = ApiParamType.JSONARRAY)
    private List<Long> idList;
    @EntityField(name = "巡检状态列表", type = ApiParamType.JSONARRAY)
    private List<String> inspectStatusList;
    @EntityField(name = "用户分组角色列表", type = ApiParamType.JSONARRAY)
    private AuthenticationInfoVo authenticationInfo;
    @EntityField(name = "IP字段映射的属性ID", type = ApiParamType.LONG)
    private Long ipFieldAttrId;
    @EntityField(name = "name字段映射的属性ID", type = ApiParamType.LONG)
    private Long nameFieldAttrId;
    @EntityField(name = "以IP字段排序", type = ApiParamType.INTEGER)
    private Integer isIpFieldSort;
    @EntityField(name = "以name字段排序", type = ApiParamType.INTEGER)
    private Integer isNameFieldSort;
    @EntityField(name = "作业ID", type = ApiParamType.LONG)
    private Long jobId;
    @EntityField(name = "输入节点列表", type = ApiParamType.JSONARRAY)
    private List<ResourceVo> inputNodeList;
    @EntityField(name = "高级搜索条件", type = ApiParamType.JSONOBJECT)
    ResourceConditionConfigVo conditionConfig;

    public ResourceQueryCriteriaVo() {
    }

    public ResourceQueryCriteriaVo(ResourceSearchVo searchVo) {
        this.keyword = searchVo.getKeyword();
        if (CollectionUtils.isNotEmpty(searchVo.getKeywordList())) {
            this.keywordList = new ArrayList<>(searchVo.getKeywordList());
        }
        if (CollectionUtils.isNotEmpty(searchVo.getProtocolIdList())) {
            this.protocolIdList = new ArrayList<>(searchVo.getProtocolIdList());
        }
        if (CollectionUtils.isNotEmpty(searchVo.getTagIdList())) {
            this.tagIdList = new ArrayList<>(searchVo.getTagIdList());
        }
        this.tagMatchMode = searchVo.getTagMatchMode();
        if (CollectionUtils.isNotEmpty(searchVo.getInspectJobPhaseNodeStatusList())) {
            this.inspectJobPhaseNodeStatusList = new ArrayList<>(searchVo.getInspectJobPhaseNodeStatusList());
        }
        this.isHasAuth = searchVo.getIsHasAuth();
        this.cmdbGroupType = searchVo.getCmdbGroupType();
        if (CollectionUtils.isNotEmpty(searchVo.getBatchSearchList())) {
            this.batchSearchList = new ArrayList<>(searchVo.getBatchSearchList());
        }
        this.searchField = searchVo.getSearchField();
        if (CollectionUtils.isNotEmpty(searchVo.getTypeIdList())) {
            this.typeIdList = new ArrayList<>(searchVo.getTypeIdList());
        }
        if (CollectionUtils.isNotEmpty(searchVo.getAuthedTypeIdList())) {
            this.authedTypeIdList = new ArrayList<>(searchVo.getAuthedTypeIdList());
        }
        if (CollectionUtils.isNotEmpty(searchVo.getStateIdList())) {
            this.stateIdList = new ArrayList<>(searchVo.getStateIdList());
        }
        if (CollectionUtils.isNotEmpty(searchVo.getVendorIdList())) {
            this.vendorIdList = new ArrayList<>(searchVo.getVendorIdList());
        }
        if (CollectionUtils.isNotEmpty(searchVo.getEnvIdList())) {
            this.envIdList = new ArrayList<>(searchVo.getEnvIdList());
        }
        this.isExistNoEnv = searchVo.getExistNoEnv();
        if (CollectionUtils.isNotEmpty(searchVo.getAppSystemIdList())) {
            this.appSystemIdList = new ArrayList<>(searchVo.getAppSystemIdList());
        }
        if (CollectionUtils.isNotEmpty(searchVo.getAppModuleIdList())) {
            this.appModuleIdList = new ArrayList<>(searchVo.getAppModuleIdList());
        }
        if (CollectionUtils.isNotEmpty(searchVo.getDefaultValue())) {
            this.defaultValue = new JSONArray(new ArrayList<>(searchVo.getDefaultValue()));
        }
        if (CollectionUtils.isNotEmpty(searchVo.getIdList())) {
            this.idList = new ArrayList<>(searchVo.getIdList());
        }
        if (CollectionUtils.isNotEmpty(searchVo.getInspectStatusList())) {
            this.inspectStatusList = new ArrayList<>(searchVo.getInspectStatusList());
        }
        this.authenticationInfo = searchVo.getAuthenticationInfo();
        this.ipFieldAttrId = searchVo.getIpFieldAttrId();
        this.nameFieldAttrId = searchVo.getNameFieldAttrId();
        this.isIpFieldSort = searchVo.getIsIpFieldSort();
        this.isNameFieldSort = searchVo.getIsNameFieldSort();
        if (CollectionUtils.isNotEmpty(searchVo.getInputNodeList())) {
            this.inputNodeList = new ArrayList<>(searchVo.getInputNodeList());
        }
        if (CollectionUtils.isNotEmpty(searchVo.getConditionGroupList())) {
            JSONObject conditionConfigObj = new JSONObject();
            conditionConfigObj.put("conditionGroupList", searchVo.getConditionGroupList());
            conditionConfigObj.put("conditionGroupRelList", searchVo.getConditionGroupRelList());
            this.conditionConfig = conditionConfigObj.toJavaObject(ResourceConditionConfigVo.class);
        }
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<String> getKeywordList() {
        return keywordList;
    }

    public void setKeywordList(List<String> keywordList) {
        this.keywordList = keywordList;
    }

    public List<Long> getProtocolIdList() {
        return protocolIdList;
    }

    public void setProtocolIdList(List<Long> protocolIdList) {
        this.protocolIdList = protocolIdList;
    }

    public List<Long> getTagIdList() {
        return tagIdList;
    }

    public void setTagIdList(List<Long> tagIdList) {
        this.tagIdList = tagIdList;
    }

    public String getTagMatchMode() {
        return tagMatchMode;
    }

    public void setTagMatchMode(String tagMatchMode) {
        this.tagMatchMode = tagMatchMode;
    }

    public List<String> getInspectJobPhaseNodeStatusList() {
        return inspectJobPhaseNodeStatusList;
    }

    public void setInspectJobPhaseNodeStatusList(List<String> inspectJobPhaseNodeStatusList) {
        this.inspectJobPhaseNodeStatusList = inspectJobPhaseNodeStatusList;
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

    public List<String> getBatchSearchList() {
        return batchSearchList;
    }

    public void setBatchSearchList(List<String> batchSearchList) {
        this.batchSearchList = batchSearchList;
    }

    public String getSearchField() {
        return searchField;
    }

    public void setSearchField(String searchField) {
        this.searchField = searchField;
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
        this.envIdList = envIdList;
    }

    public Boolean getExistNoEnv() {
        return isExistNoEnv;
    }

    public void setExistNoEnv(Boolean existNoEnv) {
        isExistNoEnv = existNoEnv;
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

    public JSONArray getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(JSONArray defaultValue) {
        this.defaultValue = defaultValue;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public List<String> getInspectStatusList() {
        return inspectStatusList;
    }

    public void setInspectStatusList(List<String> inspectStatusList) {
        this.inspectStatusList = inspectStatusList;
    }

    public AuthenticationInfoVo getAuthenticationInfo() {
        return authenticationInfo;
    }

    public void setAuthenticationInfo(AuthenticationInfoVo authenticationInfo) {
        this.authenticationInfo = authenticationInfo;
    }

    public Long getIpFieldAttrId() {
        return ipFieldAttrId;
    }

    public void setIpFieldAttrId(Long ipFieldAttrId) {
        this.ipFieldAttrId = ipFieldAttrId;
    }

    public Long getNameFieldAttrId() {
        return nameFieldAttrId;
    }

    public void setNameFieldAttrId(Long nameFieldAttrId) {
        this.nameFieldAttrId = nameFieldAttrId;
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

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public List<ResourceVo> getInputNodeList() {
        return inputNodeList;
    }

    public void setInputNodeList(List<ResourceVo> inputNodeList) {
        this.inputNodeList = inputNodeList;
    }

    public ResourceConditionConfigVo getConditionConfig() {
        return conditionConfig;
    }

    public void setConditionConfig(ResourceConditionConfigVo conditionConfig) {
        this.conditionConfig = conditionConfig;
    }
}
