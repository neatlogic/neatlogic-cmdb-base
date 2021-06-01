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
@ResourceType(name = "resource_dbinstance_bg", label = "DB实例部门")
public class DbInstanceBgVo extends ResourceEntityBaseVo {
    @EntityField(name = "分组id", type = ApiParamType.LONG)
    @ResourceField(name = "bg_id")
    private Long bgId;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    @ResourceField(name = "bg_name")
    private String bgName;
    @EntityField(name = "DB实例id", type = ApiParamType.LONG)
    @ResourceField(name = "db_instance_id")
    private Long dbInstanceId;

    public Long getBgId() {
        return bgId;
    }

    public void setBgId(Long bgId) {
        this.bgId = bgId;
    }

    public String getBgName() {
        return bgName;
    }

    public void setBgName(String bgName) {
        this.bgName = bgName;
    }

    public Long getDbInstanceId() {
        return dbInstanceId;
    }

    public void setDbInstanceId(Long dbInstanceId) {
        this.dbInstanceId = dbInstanceId;
    }
}
