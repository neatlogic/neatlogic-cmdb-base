/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter.entity;

import codedriver.framework.cmdb.annotation.ResourceField;
import codedriver.framework.cmdb.annotation.ResourceType;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

import java.util.Date;

@ResourceType(name = "resource_os_cluster", label = "操作系统集群")
public class OSClusterVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    @ResourceField(name = "id")
    private Long id;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    @ResourceField(name = "name")
    private String name;
    @EntityField(name = "类型id", type = ApiParamType.LONG)
    @ResourceField(name = "type_id")
    private Long typeId;
    @EntityField(name = "类型名称", type = ApiParamType.STRING)
    @ResourceField(name = "type_name")
    private String typeName;
    @EntityField(name = "类型label", type = ApiParamType.STRING)
    @ResourceField(name = "type_label")
    private String typeLabel;
    @EntityField(name = "维护窗口", type = ApiParamType.STRING)
    @ResourceField(name = "maintenance_window")
    private String maintenanceWindow;
    @EntityField(name = "描述", type = ApiParamType.STRING)
    @ResourceField(name = "description")
    private String description;

    @EntityField(name = "巡检状态", type = ApiParamType.STRING)
    @ResourceField(name = "inspect_status")
    private String inspectStatus;
    @EntityField(name = "巡检时间", type = ApiParamType.LONG)
    @ResourceField(name = "inspect_time")
    private Date inspectTime;
    @EntityField(name = "监控状态", type = ApiParamType.STRING)
    @ResourceField(name = "monitor_status")
    private String monitorStatus;
    @EntityField(name = "监控时间", type = ApiParamType.LONG)
    @ResourceField(name = "monitor_time")
    private Date monitorTime;
    @EntityField(name = "创建者", type = ApiParamType.STRING)
    @ResourceField(name = "fcu")
    private String fcu;
    @EntityField(name = "创建日期", type = ApiParamType.LONG)
    @ResourceField(name = "fcd")
    private Date fcd;
    @EntityField(name = "修改者", type = ApiParamType.STRING)
    @ResourceField(name = "lcu")
    private String lcu;
    @EntityField(name = "修改日期", type = ApiParamType.LONG)
    @ResourceField(name = "lcd")
    private Date lcd;

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

    public String getFcu() {
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
}
