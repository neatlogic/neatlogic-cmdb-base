/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.dto.resourcecenter.entity;

import neatlogic.framework.cmdb.annotation.ResourceField;
import neatlogic.framework.cmdb.annotation.ResourceType;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

/**
 * @author linbq
 * @since 2021/5/27 15:01
 **/
@ResourceType(name = "resource_appsystem_state", label = "应用系统状态")
@ResourceType(name = "resource_appmodule_state", label = "应用模块状态")
@ResourceType(name = "resource_ipobject_state", label = "IP软硬件状态")
public class StateVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    @ResourceField(name = "state_id")
    private Long stateId;
    @EntityField(name = "状态名", type = ApiParamType.STRING)
    @ResourceField(name = "state_name")
    private String stateName;
    @EntityField(name = "状态描述", type = ApiParamType.STRING)
    @ResourceField(name = "state_label")
    private String stateLabel;
    @EntityField(name = "资源id", type = ApiParamType.LONG)
    @ResourceField(name = "resource_id")
    private Long resourceId;

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateLabel() {
        return stateLabel;
    }

    public void setStateLabel(String stateLabel) {
        this.stateLabel = stateLabel;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}
