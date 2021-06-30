/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter;

import codedriver.framework.cmdb.annotation.ResourceField;
import codedriver.framework.cmdb.annotation.ResourceType;
import codedriver.framework.cmdb.dto.resourcecenter.entity.*;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.restful.annotation.EntityField;

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
    @EntityField(name = "类型id", type = ApiParamType.LONG)
    private Long typeId;
    @EntityField(name = "类型名称", type = ApiParamType.STRING)
    private String typeName;
    @EntityField(name = "类型label", type = ApiParamType.STRING)
    private String typeLabel;
    @EntityField(name = "网络区域id", type = ApiParamType.LONG)
    private Long netAreaId;
    @EntityField(name = "网络区域名称", type = ApiParamType.STRING)
    private String netAreaName;
    @EntityField(name = "数据中心id", type = ApiParamType.LONG)
    private Long dataCenterId;
    @EntityField(name = "数据中心名称", type = ApiParamType.STRING)
    private String dataCenterName;
    @EntityField(name = "状态id", type = ApiParamType.LONG)
    private Long statusId;
    @EntityField(name = "状态名称", type = ApiParamType.STRING)
    private String statusName;
    @EntityField(name = "应用系统id", type = ApiParamType.LONG)
    private Long appSystemId;
    @EntityField(name = "应用系统名称", type = ApiParamType.STRING)
    private String appSystemName;
    @EntityField(name = "应用模块id", type = ApiParamType.LONG)
    private Long appModuleId;
    @EntityField(name = "应用模块名称", type = ApiParamType.STRING)
    private String appModuleName;
    @EntityField(name = "应用环境id", type = ApiParamType.LONG)
    private Long envId;
    @EntityField(name = "应用环境名称", type = ApiParamType.STRING)
    private String envName;
    @EntityField(name = "维护窗口", type = ApiParamType.STRING)
    private String maintenanceWindow;
    @EntityField(name = "描述", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "IPID", type = ApiParamType.STRING)
    private String ipId;
    @EntityField(name = "IP地址", type = ApiParamType.STRING)
    private String ip;
    @EntityField(name = "端口", type = ApiParamType.INTEGER)
    private Integer port;
    @EntityField(name = "所有者列表", type = ApiParamType.JSONARRAY)
    private List<OwnerVo> ownerList;
    @EntityField(name = "所属部门列表", type = ApiParamType.JSONARRAY)
    private List<BgVo> bgList;
    @EntityField(name = "标签列表", type = ApiParamType.JSONARRAY)
    private List<String> tagList;
    @EntityField(name = "标签ID列表", type = ApiParamType.JSONARRAY)
    private List<Long> tagIdList;

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

    public Long getNetAreaId() {
        return netAreaId;
    }

    public void setNetAreaId(Long netAreaId) {
        this.netAreaId = netAreaId;
    }

    public String getNetAreaName() {
        return netAreaName;
    }

    public void setNetAreaName(String netAreaName) {
        this.netAreaName = netAreaName;
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

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
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

    public String getIpId() {
        return ipId;
    }

    public void setIpId(String ipId) {
        this.ipId = ipId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

    public List<Long> getTagIdList() {
        return tagIdList;
    }

    public void setTagIdList(List<Long> tagIdList) {
        this.tagIdList = tagIdList;
    }
}
