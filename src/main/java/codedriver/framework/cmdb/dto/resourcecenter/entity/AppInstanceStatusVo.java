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
 * @since 2021/5/27 15:01
 **/
@ResourceType(name = "resource_appinstance_status", label = "应用实例状态")
public class AppInstanceStatusVo extends ResourceEntityBaseVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    @ResourceField(name = "status_id")
    private Long statusId;
    @EntityField(name = "状态名", type = ApiParamType.STRING)
    @ResourceField(name = "status_name")
    private String statusName;
    @EntityField(name = "应用实例id", type = ApiParamType.LONG)
    @ResourceField(name = "app_instance_id")
    private Long appInstanceId;

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

    public Long getAppInstanceId() {
        return appInstanceId;
    }

    public void setAppInstanceId(Long appInstanceId) {
        this.appInstanceId = appInstanceId;
    }
}
