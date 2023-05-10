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
@ResourceType(name = "resource_appmodule_bg", label = "应用模块所属部门")
@ResourceType(name = "resource_appsystem_bg", label = "应用系统所属部门")
@ResourceType(name = "resource_ipobject_bg", label = "IP软硬件部门")
public class BgVo {
//    @EntityField(name = "分组uuid", type = ApiParamType.STRING)
//    @ResourceField(name = "bg_uuid")
//    private String uuid;
    @EntityField(name = "分组id", type = ApiParamType.LONG)
    @ResourceField(name = "bg_id")
    private Long bgId;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    @ResourceField(name = "bg_name")
    private String bgName;
    @EntityField(name = "资源id", type = ApiParamType.LONG)
    @ResourceField(name = "resource_id")
    private Long resourceId;

//    public String getUuid() {
//        return uuid;
//    }
//
//    public void setUuid(String uuid) {
//        this.uuid = uuid;
//    }

    public Long getBgId() {
        return bgId;
    }

    public void setBgId(Long bgId) {
        this.bgId = bgId;
    }

    public String getBgName() {
        return bgName;
    }

    public void setBgName(String bgName) {
        this.bgName = bgName;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}
