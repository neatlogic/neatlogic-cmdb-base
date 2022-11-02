/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BasePageVo;
import codedriver.framework.restful.annotation.EntityField;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author linbq
 * @since 2021/6/9 20:01
 **/
public class ResourceSearchVo extends BasePageVo {
    @EntityField(name = "类型id", type = ApiParamType.LONG)
    private Long typeId;
    @EntityField(name = "类型id列表", type = ApiParamType.JSONARRAY)
    private List<Long> typeIdList;
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
    @EntityField(name = "批量搜索值", type = ApiParamType.STRING)
    private String searchValue;
    @EntityField(name = "批量搜索值列表", type = ApiParamType.JSONARRAY)
    private List<String> searchValueList;
    public ResourceSearchVo() {
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

    public List<Long> getEnvIdList() {
        return envIdList;
    }

    public void setEnvIdList(List<Long> envIdList) {
        this.envIdList = envIdList;
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

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public List<String> getSearchValueList() {
        if (CollectionUtils.isEmpty(searchValueList) && StringUtils.isNotBlank(searchValue)) {
            String[] split = searchValue.split("\n");
            searchValueList = Arrays.asList(split);
        }
        return searchValueList;
    }

    public void setSearchValueList(List<String> searchValueList) {
        this.searchValueList = searchValueList;
    }
}
