/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter.entity;

import codedriver.framework.cmdb.annotation.ResourceField;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

/**
 * @author linbq
 * @since 2021/5/31 16:47
 **/
public class DataCenterVo extends ResourceEntityBaseVo {
    @EntityField(name = "数据中心id", type = ApiParamType.LONG)
    @ResourceField(name = "data_center_id")
    private Long id;
    @EntityField(name = "数据中心名称", type = ApiParamType.STRING)
    @ResourceField(name = "data_center_name")
    private String name;
    @EntityField(name = "描述", type = ApiParamType.STRING)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
