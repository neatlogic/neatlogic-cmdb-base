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
