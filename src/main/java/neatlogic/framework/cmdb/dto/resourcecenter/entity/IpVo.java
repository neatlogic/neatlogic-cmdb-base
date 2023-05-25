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

/**
 * @author linbq
 * @since 2021/5/27 12:02
 **/
@ResourceType(name = "resource_ipobject_allip", label = "IP软硬件ip列表")
public class IpVo {

    @EntityField(name = "ip的id", type = ApiParamType.LONG)
    @ResourceField(name = "allip_id")
    private Long allIpId;
    @EntityField(name = "ip", type = ApiParamType.STRING)
    @ResourceField(name = "allip_ip")
    private String allIpIp;
    @EntityField(name = "ip描述", type = ApiParamType.STRING)
    @ResourceField(name = "allip_label")
    private String allIpLabel;
    @EntityField(name = "资源id", type = ApiParamType.LONG)
    @ResourceField(name = "resource_id")
    private Long resourceId;

    public Long getAllIpId() {
        return allIpId;
    }

    public void setAllIpId(Long allIpId) {
        this.allIpId = allIpId;
    }

    public String getAllIpIp() {
        return allIpIp;
    }

    public void setAllIpIp(String allIpIp) {
        this.allIpIp = allIpIp;
    }

    public String getAllIpLabel() {
        return allIpLabel;
    }

    public void setAllIpLabel(String allIpLabel) {
        this.allIpLabel = allIpLabel;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}