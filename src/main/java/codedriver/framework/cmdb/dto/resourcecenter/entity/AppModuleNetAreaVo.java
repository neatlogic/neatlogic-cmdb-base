/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter.entity;

import codedriver.framework.cmdb.annotation.ResourceField;
import codedriver.framework.cmdb.annotation.ResourceType;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

@ResourceType(name = "resource_appmodule_netarea", label = "应用模块网络区域")
public class AppModuleNetAreaVo {
    @EntityField(name = "网络区域id", type = ApiParamType.LONG)
    @ResourceField(name = "netarea_id")
    private Long netareaId;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    @ResourceField(name = "name")
    private String name;
    @EntityField(name = "应用系统id", type = ApiParamType.LONG)
    @ResourceField(name = "app_module_id")
    private Long appModuleId;

    public Long getNetareaId() {
        return netareaId;
    }

    public void setNetareaId(Long netareaId) {
        this.netareaId = netareaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAppModuleId() {
        return appModuleId;
    }

    public void setAppModuleId(Long appModuleId) {
        this.appModuleId = appModuleId;
    }
}
