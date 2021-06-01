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
@ResourceType(name = "resource_dbinstance_datacenter", label = "DB实例数据中心")
public class DbInstanceDataCenterVo extends ResourceEntityBaseVo {
    @EntityField(name = "网络区域id", type = ApiParamType.LONG)
    @ResourceField(name = "datacenter_id")
    private Long dataCenterId;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    @ResourceField(name = "datacenter_name")
    private String name;
    @EntityField(name = "应用实例id", type = ApiParamType.LONG)
    @ResourceField(name = "db_instance_id")
    private Long dbInstanceId;

    public Long getDataCenterId() {
        return dataCenterId;
    }

    public void setDataCenterId(Long dataCenterId) {
        this.dataCenterId = dataCenterId;
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
