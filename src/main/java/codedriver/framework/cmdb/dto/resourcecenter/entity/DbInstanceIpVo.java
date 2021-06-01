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
@ResourceType(name = "resource_dbinstance_ip", label = "DB实例ip")
public class DbInstanceIpVo extends ResourceEntityBaseVo {
    @EntityField(name = "ip", type = ApiParamType.STRING)
    @ResourceField(name = "ip")
    private String ip;
    @EntityField(name = "DB实例id", type = ApiParamType.LONG)
    @ResourceField(name = "db_instance_id")
    private Long dbInstanceId;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getDbInstanceId() {
        return dbInstanceId;
    }

    public void setDbInstanceId(Long dbInstanceId) {
        this.dbInstanceId = dbInstanceId;
    }
}
