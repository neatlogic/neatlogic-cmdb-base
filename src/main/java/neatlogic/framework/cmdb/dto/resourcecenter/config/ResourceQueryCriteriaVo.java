/*
 * Copyright (C) 2025  深圳极向量科技有限公司 All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package neatlogic.framework.cmdb.dto.resourcecenter.config;

import com.alibaba.fastjson.JSONArray;
import neatlogic.framework.cmdb.dto.resourcecenter.ResourceSearchVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.dto.AuthenticationInfoVo;
import neatlogic.framework.restful.annotation.EntityField;

import java.util.List;

public class ResourceQueryCriteriaVo {
    private String keyword;
    private List<String> keywordList;
    @EntityField(name = "协议id列表", type = ApiParamType.JSONARRAY)
    private List<Long> protocolIdList;
    @EntityField(name = "标签id列表", type = ApiParamType.JSONARRAY)
    private List<Long> tagIdList;
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
    public ResourceQueryCriteriaVo() {
    }

    public ResourceQueryCriteriaVo(ResourceSearchVo searchVo) {
        this.keyword = searchVo.getKeyword();
        this.keywordList = searchVo.getKeywordList();
        this.protocolIdList = searchVo.getProtocolIdList();
        this.tagIdList = searchVo.getTagIdList();
        this.inspectJobPhaseNodeStatusList = searchVo.getInspectJobPhaseNodeStatusList();
        this.isHasAuth = searchVo.getIsHasAuth();
        this.cmdbGroupType = searchVo.getCmdbGroupType();
        this.batchSearchList = searchVo.getBatchSearchList();
        this.searchField = searchVo.getSearchField();
        this.typeIdList = searchVo.getTypeIdList();
        this.authedTypeIdList = searchVo.getAuthedTypeIdList();
        this.stateIdList = searchVo.getStateIdList();
        this.vendorIdList = searchVo.getVendorIdList();
        this.envIdList = searchVo.getEnvIdList();
        this.isExistNoEnv = searchVo.getExistNoEnv();
        this.appSystemIdList = searchVo.getAppSystemIdList();
        this.appModuleIdList = searchVo.getAppModuleIdList();
        this.defaultValue = searchVo.getDefaultValue();
        this.idList = searchVo.getIdList();
        this.inspectStatusList = searchVo.getInspectStatusList();
        this.authenticationInfo = searchVo.getAuthenticationInfo();
        this.ipFieldAttrId = searchVo.getIpFieldAttrId();
        this.nameFieldAttrId = searchVo.getNameFieldAttrId();
        this.isIpFieldSort = searchVo.getIsIpFieldSort();
        this.isNameFieldSort = searchVo.getIsNameFieldSort();
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
}
