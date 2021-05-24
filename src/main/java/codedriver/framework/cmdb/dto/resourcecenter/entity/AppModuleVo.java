/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter.entity;

import codedriver.framework.cmdb.annotation.ResourceField;
import codedriver.framework.cmdb.annotation.ResourceType;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

import java.util.List;

@ResourceType(name = "resource_appmodule", label = "应用系统模块")
public class AppModuleVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    @ResourceField(name = "id")
    private Long id;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    @ResourceField(name = "name")
    private String name;
    @EntityField(name = "所属部门列表", type = ApiParamType.JSONARRAY)
    private List<AppSystemBgVo> bgList;
    @EntityField(name = "状态id", type = ApiParamType.LONG)
    private Long status;
    @EntityField(name = "状态名称", type = ApiParamType.STRING)
    private String statusName;
    @EntityField(name = "所有者列表", type = ApiParamType.JSONARRAY)
    private List<AppSystemOwnerVo> ownerList;
    @EntityField(name = "维护窗口", type = ApiParamType.STRING)
    @ResourceField(name = "maintenance_window")
    private String maintenanceWindow;
    @EntityField(name = "描述", type = ApiParamType.STRING)
    @ResourceField(name = "description")
    private String description;
    @EntityField(name = "网络区域列表", type = ApiParamType.JSONARRAY)
    private List<AppSystemNetAreaVo> netAreaList;

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

    public List<AppSystemBgVo> getBgList() {
        return bgList;
    }

    public void setBgList(List<AppSystemBgVo> bgList) {
        this.bgList = bgList;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public List<AppSystemOwnerVo> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<AppSystemOwnerVo> ownerList) {
        this.ownerList = ownerList;
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

    public List<AppSystemNetAreaVo> getNetAreaList() {
        return netAreaList;
    }

    public void setNetAreaList(List<AppSystemNetAreaVo> netAreaList) {
        this.netAreaList = netAreaList;
    }
}
