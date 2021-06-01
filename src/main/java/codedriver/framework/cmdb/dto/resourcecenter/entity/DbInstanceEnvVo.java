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
@ResourceType(name = "resource_dbinstance_env", label = "应用实例环境")
public class DbInstanceEnvVo extends ResourceEntityBaseVo {
    @EntityField(name = "环境id", type = ApiParamType.LONG)
    @ResourceField(name = "env_id")
    private Long envId;
    @EntityField(name = "环境名称", type = ApiParamType.STRING)
    @ResourceField(name = "env_name")
    private String name;
    @EntityField(name = "应用实例id", type = ApiParamType.LONG)
    @ResourceField(name = "db_instance_id")
    private Long dbInstanceId;

    public Long getEnvId() {
        return envId;
    }

    public void setEnvId(Long envId) {
        this.envId = envId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDbInstanceId() {
        return dbInstanceId;
    }

    public void setDbInstanceId(Long dbInstanceId) {
        this.dbInstanceId = dbInstanceId;
    }
}
