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
 * @since 2021/5/27 14:29
 **/
//@ResourceType(name = "resource_appinstance_netarea", label = "应用实例网络区域")
//@ResourceType(name = "resource_dbinstance_netarea", label = "DB实例网络区域")
@ResourceType(name = "resource_ipobject_netarea", label = "IP软硬件网络区域")
public class NetworkAreaVo {
    @EntityField(name = "网络区域id", type = ApiParamType.LONG)
    @ResourceField(name = "netarea_id")
    private Long netAreaId;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    @ResourceField(name = "netarea_name")
    private String netAreaName;
    @EntityField(name = "资源id", type = ApiParamType.LONG)
    @ResourceField(name = "resource_id")
    private Long resourceId;

    public Long getNetAreaId() {
        return netAreaId;
    }

    public void setNetAreaId(Long netAreaId) {
        this.netAreaId = netAreaId;
    }

    public String getNetAreaName() {
        return netAreaName;
    }

    public void setNetAreaName(String netAreaName) {
        this.netAreaName = netAreaName;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}
