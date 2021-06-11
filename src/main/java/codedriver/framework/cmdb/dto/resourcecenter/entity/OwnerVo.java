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
 * @since 2021/5/27 14:07
 **/
//@ResourceType(name = "resource_appinstance_owner", label = "应用实例所有人")
//@ResourceType(name = "resource_dbinstance_owner", label = "DB实例所有人")
@ResourceType(name = "resource_appmodule_owner", label = "应用模块所有人")
@ResourceType(name = "resource_appsystem_owner", label = "应用系统所有人")
@ResourceType(name = "resource_ipobject_owner", label = "IP软硬件所有人")
public class OwnerVo {
    @EntityField(name = "用户uuid", type = ApiParamType.STRING)
    @ResourceField(name = "user_uuid")
    private String uuid;
    @EntityField(name = "id", type = ApiParamType.LONG)
    @ResourceField(name = "user_id")
    private Long userId;
    @EntityField(name = "用户名", type = ApiParamType.STRING)
    @ResourceField(name = "user_name")
    private String userName;
    @EntityField(name = "资源id", type = ApiParamType.LONG)
    @ResourceField(name = "resource_id")
    private Long resourceId;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}
