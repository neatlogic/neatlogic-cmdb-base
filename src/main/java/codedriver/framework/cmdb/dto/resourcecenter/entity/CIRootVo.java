/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter.entity;

import codedriver.framework.cmdb.annotation.ResourceField;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

import java.util.List;

public class CIRootVo extends ResourceEntityBaseVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    @ResourceField(name = "id")
    private Long id;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    @ResourceField(name = "name")
    private String name;
    @EntityField(name = "维护窗口", type = ApiParamType.STRING)
    @ResourceField(name = "maintenance_window")
    private String maintenanceWindow;
    @EntityField(name = "描述", type = ApiParamType.STRING)
    @ResourceField(name = "description")
    private String description;
    @EntityField(name = "类型id", type = ApiParamType.STRING)
    @ResourceField(name = "type_id")
    private String typeId;
    @EntityField(name = "类型名", type = ApiParamType.STRING)
    @ResourceField(name = "typeName")
    private String typeName;
    @EntityField(name = "状态", type = ApiParamType.JSONOBJECT)
    private StatusVo statusVo;
    @EntityField(name = "所有者列表", type = ApiParamType.JSONARRAY)
    private List<OwnerVo> ownerList;
    @EntityField(name = "所属部门列表", type = ApiParamType.JSONARRAY)
    private List<TeamVo> bgList;
//    @EntityField(name = "网络区域列表", type = ApiParamType.JSONARRAY)
//    private List<NetAreaVo> networkAreaList;
    @EntityField(name = "数据中心", type = ApiParamType.JSONOBJECT)
    private DataCenterVo dataCenterVo;

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

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public StatusVo getStatusVo() {
        return statusVo;
    }

    public void setStatusVo(StatusVo statusVo) {
        this.statusVo = statusVo;
    }

    public List<OwnerVo> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<OwnerVo> ownerList) {
        this.ownerList = ownerList;
    }

    public List<TeamVo> getBgList() {
        return bgList;
    }

    public void setBgList(List<TeamVo> bgList) {
        this.bgList = bgList;
    }

    public DataCenterVo getDataCenterVo() {
        return dataCenterVo;
    }

    public void setDataCenterVo(DataCenterVo dataCenterVo) {
        this.dataCenterVo = dataCenterVo;
    }
}
