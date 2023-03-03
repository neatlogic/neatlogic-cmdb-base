/*
Copyright(c) $today.year NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package neatlogic.framework.cmdb.dto.resourcecenter;

import neatlogic.framework.cmdb.dto.tag.TagVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.constvalue.InspectStatus;
import neatlogic.framework.common.dto.BaseEditorVo;
import neatlogic.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author linbq
 * @since 2021/5/27 16:50
 **/
public class ResourceVo extends BaseEditorVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "简称", type = ApiParamType.STRING)
    private String abbrName;
    @EntityField(name = "类型id", type = ApiParamType.LONG)
    private Long typeId;
    @EntityField(name = "类型名称", type = ApiParamType.STRING)
    private String typeName;
    @EntityField(name = "类型label", type = ApiParamType.STRING)
    private String typeLabel;
    @EntityField(name = "网络区域", type = ApiParamType.STRING)
    private String networkArea;
    @EntityField(name = "数据中心id", type = ApiParamType.LONG)
    private Long dataCenterId;
    @EntityField(name = "数据中心名称", type = ApiParamType.STRING)
    private String dataCenterName;
    @EntityField(name = "状态id", type = ApiParamType.LONG)
    private Long stateId;
    @EntityField(name = "状态名称", type = ApiParamType.STRING)
    private String stateName;
    @EntityField(name = "状态描述", type = ApiParamType.STRING)
    private String stateLabel;
    @EntityField(name = "应用系统id", type = ApiParamType.LONG)
    private Long appSystemId;
    @EntityField(name = "应用系统名称", type = ApiParamType.STRING)
    private String appSystemName;
    @EntityField(name = "应用系统简称", type = ApiParamType.STRING)
    private String appSystemAbbrName;
    @EntityField(name = "应用模块id", type = ApiParamType.LONG)
    private Long appModuleId;
    @EntityField(name = "应用模块名称", type = ApiParamType.STRING)
    private String appModuleName;
    @EntityField(name = "应用模块简称", type = ApiParamType.STRING)
    private String appModuleAbbrName;
    @EntityField(name = "应用环境id", type = ApiParamType.LONG)
    private Long envId;
    @EntityField(name = "应用环境名称", type = ApiParamType.STRING)
    private String envName;
    @EntityField(name = "应用环境序号", type = ApiParamType.INTEGER)
    private Integer envSeqNo;
    @EntityField(name = "维护窗口", type = ApiParamType.STRING)
    private String maintenanceWindow;
    @EntityField(name = "描述", type = ApiParamType.STRING)
    private String description;
    //    @EntityField(name = "IPID", type = ApiParamType.STRING)
//    private String ipId;
    @EntityField(name = "IP地址", type = ApiParamType.STRING)
    private String ip;
    @EntityField(name = "IP列表", type = ApiParamType.JSONARRAY)
    private List<IpVo> allIp;
    @EntityField(name = "端口", type = ApiParamType.INTEGER)
    private Integer port;
    @EntityField(name = "所有者列表", type = ApiParamType.JSONARRAY)
    private List<OwnerVo> ownerList;
    @EntityField(name = "所属部门列表", type = ApiParamType.JSONARRAY)
    private List<BgVo> bgList;
    @EntityField(name = "标签名称列表", type = ApiParamType.JSONARRAY)
    private List<String> tagList;
    @EntityField(name = "帐号列表", type = ApiParamType.JSONARRAY)
    private List<AccountVo> accountList;
    @EntityField(name = "标签列表", type = ApiParamType.JSONARRAY)
    private List<TagVo> tagVoList;
    @EntityField(name = "集群id", type = ApiParamType.LONG)
    private Long clusterId;
    @EntityField(name = "集群名", type = ApiParamType.STRING)
    private String clusterName;
    @EntityField(name = "集群类型id", type = ApiParamType.LONG)
    private Long clusterTypeId;

    @EntityField(name = "巡检状态", type = ApiParamType.STRING)
    private String inspectStatus;
    @EntityField(name = "巡检状态Vo", type = ApiParamType.JSONOBJECT)
    private JSONObject inspectStatusJson;
    @EntityField(name = "巡检时间", type = ApiParamType.LONG)
    private Date inspectTime;
    @EntityField(name = "监控状态", type = ApiParamType.STRING)
    private String monitorStatus;
    @EntityField(name = "监控时间", type = ApiParamType.LONG)
    private Date monitorTime;

    @EntityField(name = "监控状态Vo", type = ApiParamType.JSONOBJECT)
    private JSONObject monitorStatusJson;
    @EntityField(name = "监控端口", type = ApiParamType.INTEGER)
    private Integer listenPort;

    public ResourceVo() {
    }

    public ResourceVo(String ip, Integer port, String name) {
        this.ip = ip;
        this.port = port;
        this.name = name;
    }

    public ResourceVo(Long appSystemId, Long appModuleId, Long envId) {
        this.appSystemId = appSystemId;
        this.appModuleId = appModuleId;
        this.envId = envId;
    }

    public ResourceVo(ResourceVo resourceVo) {
        this.id = resourceVo.id;
        this.name = resourceVo.name;
        this.abbrName = resourceVo.abbrName;
        this.typeId = resourceVo.typeId;
        this.typeName = resourceVo.typeName;
        this.typeLabel = resourceVo.typeLabel;
        this.networkArea = resourceVo.networkArea;
        this.dataCenterId = resourceVo.dataCenterId;
        this.dataCenterName = resourceVo.dataCenterName;
        this.stateId = resourceVo.stateId;
        this.stateName = resourceVo.stateName;
        this.stateLabel = resourceVo.stateLabel;
        this.appSystemId = resourceVo.appSystemId;
        this.appSystemName = resourceVo.appSystemName;
        this.appSystemAbbrName = resourceVo.appSystemAbbrName;
        this.appModuleId = resourceVo.appModuleId;
        this.appModuleName = resourceVo.appModuleName;
        this.appModuleAbbrName = resourceVo.appModuleAbbrName;
        this.envId = resourceVo.envId;
        this.envName = resourceVo.envName;
        this.envSeqNo = resourceVo.envSeqNo;
        this.maintenanceWindow = resourceVo.maintenanceWindow;
        this.description = resourceVo.description;
        this.ip = resourceVo.ip;
        this.allIp = resourceVo.allIp;
        this.port = resourceVo.port;
        this.ownerList = resourceVo.ownerList;
        this.bgList = resourceVo.bgList;
        this.tagList = resourceVo.tagList;
        this.accountList = resourceVo.accountList;
        this.tagVoList = resourceVo.tagVoList;
        this.clusterId = resourceVo.clusterId;
        this.clusterName = resourceVo.clusterName;
        this.clusterTypeId = resourceVo.clusterTypeId;
        this.inspectStatus = resourceVo.inspectStatus;
        this.inspectStatusJson = resourceVo.inspectStatusJson;
        this.inspectTime = resourceVo.inspectTime;
        this.monitorStatus = resourceVo.monitorStatus;
        this.monitorTime = resourceVo.monitorTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbrName() {
        return abbrName;
    }

    public void setAbbrName(String abbrName) {
        this.abbrName = abbrName;
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

    public String getTypeLabel() {
        return typeLabel;
    }

    public void setTypeLabel(String typeLabel) {
        this.typeLabel = typeLabel;
    }

    public String getNetworkArea() {
        return networkArea;
    }

    public void setNetworkArea(String networkArea) {
        this.networkArea = networkArea;
    }

    public Long getDataCenterId() {
        return dataCenterId;
    }

    public void setDataCenterId(Long dataCenterId) {
        this.dataCenterId = dataCenterId;
    }

    public String getDataCenterName() {
        return dataCenterName;
    }

    public void setDataCenterName(String dataCenterName) {
        this.dataCenterName = dataCenterName;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateLabel() {
        return stateLabel;
    }

    public void setStateLabel(String stateLabel) {
        this.stateLabel = stateLabel;
    }

    public Long getAppSystemId() {
        return appSystemId;
    }

    public void setAppSystemId(Long appSystemId) {
        this.appSystemId = appSystemId;
    }

    public String getAppSystemName() {
        return appSystemName;
    }

    public void setAppSystemName(String appSystemName) {
        this.appSystemName = appSystemName;
    }

    public String getAppSystemAbbrName() {
        return appSystemAbbrName;
    }

    public void setAppSystemAbbrName(String appSystemAbbrName) {
        this.appSystemAbbrName = appSystemAbbrName;
    }

    public Long getAppModuleId() {
        return appModuleId;
    }

    public void setAppModuleId(Long appModuleId) {
        this.appModuleId = appModuleId;
    }

    public String getAppModuleName() {
        return appModuleName;
    }

    public void setAppModuleName(String appModuleName) {
        this.appModuleName = appModuleName;
    }

    public String getAppModuleAbbrName() {
        return appModuleAbbrName;
    }

    public void setAppModuleAbbrName(String appModuleAbbrName) {
        this.appModuleAbbrName = appModuleAbbrName;
    }

    public Long getEnvId() {
        return envId;
    }

    public void setEnvId(Long envId) {
        this.envId = envId;
    }

    public String getEnvName() {
        return envName;
    }

    public void setEnvName(String envName) {
        this.envName = envName;
    }

    public Integer getEnvSeqNo() {
        return envSeqNo;
    }

    public void setEnvSeqNo(Integer envSeqNo) {
        this.envSeqNo = envSeqNo;
    }

    public String getMaintenanceWindow() {
        return maintenanceWindow;
    }

    public void setMaintenanceWindow(String maintenanceWindow) {
        this.maintenanceWindow = maintenanceWindow;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public String getIpId() {
//        return ipId;
//    }
//
//    public void setIpId(String ipId) {
//        this.ipId = ipId;
//    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public List<IpVo> getAllIp() {
        return allIp;
    }

    public void setAllIp(List<IpVo> allIp) {
        this.allIp = allIp;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public List<OwnerVo> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<OwnerVo> ownerList) {
        this.ownerList = ownerList;
    }

    public List<BgVo> getBgList() {
        return bgList;
    }

    public void setBgList(List<BgVo> bgList) {
        this.bgList = bgList;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public List<AccountVo> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<AccountVo> accountList) {
        this.accountList = accountList;
    }

    public List<TagVo> getTagVoList() {
        return tagVoList;
    }

    public void setTagVoList(List<TagVo> tagVoList) {
        this.tagVoList = tagVoList;
    }

    public Long getClusterId() {
        return clusterId;
    }

    public void setClusterId(Long clusterId) {
        this.clusterId = clusterId;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public Long getClusterTypeId() {
        return clusterTypeId;
    }

    public void setClusterTypeId(Long clusterTypeId) {
        this.clusterTypeId = clusterTypeId;
    }

    public String getInspectStatus() {
        return inspectStatus;
    }

    public void setInspectStatus(String inspectStatus) {
        this.inspectStatus = inspectStatus;
    }

    public Date getInspectTime() {
        return inspectTime;
    }

    public void setInspectTime(Date inspectTime) {
        this.inspectTime = inspectTime;
    }

    public String getMonitorStatus() {
        return monitorStatus;
    }

    public void setMonitorStatus(String monitorStatus) {
        this.monitorStatus = monitorStatus;
    }

    public Date getMonitorTime() {
        return monitorTime;
    }

    public void setMonitorTime(Date monitorTime) {
        this.monitorTime = monitorTime;
    }

    public JSONObject getInspectStatusJson() {
        if (StringUtils.isNotBlank(inspectStatus)) {
            inspectStatusJson = InspectStatus.getInspectStatusJson(inspectStatus);
        }
        return inspectStatusJson;
    }

    public JSONObject getMonitorStatusJson() {
        if (StringUtils.isNotBlank(monitorStatus)) {
            monitorStatusJson = InspectStatus.getInspectStatusJson(monitorStatus);
        }
        return monitorStatusJson;
    }

    public Integer getListenPort() {
        return listenPort;
    }

    public void setListenPort(Integer listenPort) {
        this.listenPort = listenPort;
    }
}
