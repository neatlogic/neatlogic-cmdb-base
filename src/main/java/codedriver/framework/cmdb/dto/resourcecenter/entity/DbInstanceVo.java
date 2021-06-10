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

@ResourceType(name = "resource_dbinstance", ciName = "DBIns", label = "DB实例")
public class DbInstanceVo extends ResourceEntityBaseVo {
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
    @EntityField(name = "所属部门列表", type = ApiParamType.JSONARRAY)
    private List<DbInstanceBgVo> bgList;
    @EntityField(name = "状态id", type = ApiParamType.LONG)
    private Long status;
    @EntityField(name = "状态名称", type = ApiParamType.STRING)
    private String statusName;
    @EntityField(name = "所有者列表", type = ApiParamType.JSONARRAY)
    private List<DbInstanceOwnerVo> ownerList;
    @EntityField(name = "维护窗口", type = ApiParamType.STRING)
    @ResourceField(name = "maintenance_window")
    private String maintenanceWindow;
    @EntityField(name = "描述", type = ApiParamType.STRING)
    @ResourceField(name = "description")
    private String description;
    @EntityField(name = "网络区域列表", type = ApiParamType.JSONARRAY)
    private List<DbInstanceNetAreaVo> netAreaList;
    @EntityField(name = "ip", type = ApiParamType.JSONOBJECT)
    private DbInstanceIpVo dbInstanceIpVo;
    @EntityField(name = "port", type = ApiParamType.INTEGER)
    @ResourceField(name = "port")
    private Integer port;

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

    public List<DbInstanceBgVo> getBgList() {
        return bgList;
    }

    public void setBgList(List<DbInstanceBgVo> bgList) {
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

    public List<DbInstanceOwnerVo> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<DbInstanceOwnerVo> ownerList) {
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

    public List<DbInstanceNetAreaVo> getNetAreaList() {
        return netAreaList;
    }

    public void setNetAreaList(List<DbInstanceNetAreaVo> netAreaList) {
        this.netAreaList = netAreaList;
    }

    public DbInstanceIpVo getDbInstanceIpVo() {
        return dbInstanceIpVo;
    }

    public void setDbInstanceIpVo(DbInstanceIpVo dbInstanceIpVo) {
        this.dbInstanceIpVo = dbInstanceIpVo;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
