/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter.config;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;

import java.util.List;

public class ResourceCenterConfigVo extends BaseEditorVo {
    @EntityField(name = "主键id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "配置信息", type = ApiParamType.STRING)
    private String config;
    @EntityField(name = "视图列表信息")
    private List<ResourceEntityVo> resourceEntityList;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public List<ResourceEntityVo> getResourceEntityList() {
        return resourceEntityList;
    }

    public void setResourceEntityList(List<ResourceEntityVo> resourceEntityList) {
        this.resourceEntityList = resourceEntityList;
    }
}
