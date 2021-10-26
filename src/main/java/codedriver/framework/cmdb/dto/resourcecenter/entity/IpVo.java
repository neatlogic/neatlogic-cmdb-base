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
@ResourceType(name = "resource_ipobject_ip", label = "IP软硬件ip")
public class IpVo {

    @EntityField(name = "IPid", type = ApiParamType.LONG)
    @ResourceField(name = "ip_id")
    private Long id;
    @EntityField(name = "ip", type = ApiParamType.STRING)
    @ResourceField(name = "ip")
    private String ip;
    @EntityField(name = "资源id", type = ApiParamType.LONG)
    @ResourceField(name = "resource_id")
    private Long resourceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}
