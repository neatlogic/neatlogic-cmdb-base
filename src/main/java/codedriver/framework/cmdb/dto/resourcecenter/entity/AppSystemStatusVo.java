/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter.entity;

import codedriver.framework.cmdb.annotation.ResourceField;
import codedriver.framework.cmdb.annotation.ResourceType;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

@ResourceType(name = "resource_appsystem_status", label = "应用系统状态")
public class AppSystemStatusVo extends ResourceEntityBaseVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    @ResourceField(name = "status_id")
    private Long statusId;
    @EntityField(name = "状态名", type = ApiParamType.STRING)
    @ResourceField(name = "status_name")
    private String statusName;
    @EntityField(name = "应用系统id", type = ApiParamType.LONG)
    @ResourceField(name = "app_system_id")
    private Long appSystemId;

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Long getAppSystemId() {
        return appSystemId;
    }

    public void setAppSystemId(Long appSystemId) {
        this.appSystemId = appSystemId;
    }
}
