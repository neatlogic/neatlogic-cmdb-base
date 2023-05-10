/*
Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.

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

package neatlogic.framework.cmdb.dto.resourcecenter.entity;

import neatlogic.framework.cmdb.annotation.ResourceField;
import neatlogic.framework.cmdb.annotation.ResourceType;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

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
