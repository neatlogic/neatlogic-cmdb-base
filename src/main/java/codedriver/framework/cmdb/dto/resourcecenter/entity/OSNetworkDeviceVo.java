/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter.entity;

import codedriver.framework.cmdb.annotation.ResourceField;
import codedriver.framework.cmdb.annotation.ResourceType;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

@ResourceType(name = "resource_os_networkdevice", label = "操作系统与网络设备关系")
public class OSNetworkDeviceVo {
    @EntityField(name = "网络设备id", type = ApiParamType.LONG)
    @ResourceField(name = "networkdevice_id")
    private Long networkDeviceId;
    @EntityField(name = "网络设备名称", type = ApiParamType.STRING)
    @ResourceField(name = "networkdevice_name")
    private String networkDeviceName;
    @EntityField(name = "网络设备类型id", type = ApiParamType.LONG)
    @ResourceField(name = "type_id")
    private Long typeId;
    @EntityField(name = "资源id", type = ApiParamType.LONG)
    @ResourceField(name = "resource_id")
    private Long resourceId;

    public Long getNetworkDeviceId() {
        return networkDeviceId;
    }

    public void setNetworkDeviceId(Long networkDeviceId) {
        this.networkDeviceId = networkDeviceId;
    }

    public String getNetworkDeviceName() {
        return networkDeviceName;
    }

    public void setNetworkDeviceName(String networkDeviceName) {
        this.networkDeviceName = networkDeviceName;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}
