/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter.entity;

import codedriver.framework.cmdb.annotation.ResourceField;
import codedriver.framework.cmdb.annotation.ResourceType;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

@ResourceType(name = "resource_appinstance_appsystem", label = "应用实例系统关系")
public class AppInstanceSystemVo extends ResourceEntityBaseVo {
    @EntityField(name = "应用实例id", type = ApiParamType.LONG)
    @ResourceField(name = "app_instance_id")
    private Long appInstanceId;
    @EntityField(name = "系统id", type = ApiParamType.LONG)
    @ResourceField(name = "app_system_id")
    private Long appSystemId;
    @EntityField(name = "系统名", type = ApiParamType.STRING)
    @ResourceField(name = "app_system_name")
    private String appSystemName;

    public Long getAppInstanceId() {
        return appInstanceId;
    }

    public void setAppInstanceId(Long appInstanceId) {
        this.appInstanceId = appInstanceId;
    }

    public Long getAppSystemId() {
        return appSystemId;
    }

    public void setAppSystemId(Long appSystemId) {
        this.appSystemId = appSystemId;
    }

    public String getAppSystemName() {
        return appSystemName;
    }

    public void setAppSystemName(String appSystemName) {
        this.appSystemName = appSystemName;
    }
}
