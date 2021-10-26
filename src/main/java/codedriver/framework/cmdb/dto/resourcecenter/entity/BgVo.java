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
