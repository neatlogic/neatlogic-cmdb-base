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
@ResourceType(name = "resource_dbinstance_netarea", label = "DB实例网络区域")
public class DbInstanceNetAreaVo extends ResourceEntityBaseVo {
    @EntityField(name = "网络区域id", type = ApiParamType.LONG)
    @ResourceField(name = "netarea_id")
    private Long netareaId;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    @ResourceField(name = "netarea_name")
    private String name;
    @EntityField(name = "DB实例id", type = ApiParamType.LONG)
    @ResourceField(name = "db_instance_id")
    private Long dbInstanceId;

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

    public Long getDbInstanceId() {
        return dbInstanceId;
    }

    public void setDbInstanceId(Long dbInstanceId) {
        this.dbInstanceId = dbInstanceId;
    }
}
