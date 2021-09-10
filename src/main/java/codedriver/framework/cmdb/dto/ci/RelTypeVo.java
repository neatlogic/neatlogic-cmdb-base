/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.ci;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class RelTypeVo implements Serializable {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "中文名", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "引用数", type = ApiParamType.INTEGER)
    private Integer invokeCount;
    @EntityField(name = "备注", type = ApiParamType.STRING)
    private String description;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (StringUtils.isNotBlank(name)) {
            name = name.trim();
        }
        this.name = name;
    }

    public Integer getInvokeCount() {
        return invokeCount;
    }

    public void setInvokeCount(Integer invokeCount) {
        this.invokeCount = invokeCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
