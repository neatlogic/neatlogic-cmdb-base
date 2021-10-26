/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter.entity;

import codedriver.framework.cmdb.annotation.ResourceField;
import codedriver.framework.cmdb.annotation.ResourceType;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

/**
 * @author linbq
 * @since 2021/5/27 14:29
 **/
@ResourceType(name = "resource_appsystem_datacenter", label = "应用系统数据中心")
@ResourceType(name = "resource_appmodule_datacenter", label = "应用模块数据中心")
@ResourceType(name = "resource_ipobject_datacenter", label = "IP软硬件数据中心")
public class DataCenterVo {
    @EntityField(name = "数据中心id", type = ApiParamType.LONG)
    @ResourceField(name = "datacenter_id")
    private Long dataCenterId;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    @ResourceField(name = "datacenter_name")
    private String dataCenterName;
    @EntityField(name = "资源id", type = ApiParamType.LONG)
    @ResourceField(name = "resource_id")
    private Long resourceId;

    public Long getDataCenterId() {
        return dataCenterId;
    }

    public void setDataCenterId(Long dataCenterId) {
        this.dataCenterId = dataCenterId;
    }

    public String getDataCenterName() {
        return dataCenterName;
    }

    public void setDataCenterName(String datacenterName) {
        this.dataCenterName = datacenterName;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}
