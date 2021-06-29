/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.ci;

import org.apache.commons.lang3.StringUtils;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;

public class RelTypeVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "中文名", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "引用数", type = ApiParamType.INTEGER)
    private Integer invokeCount;
    //    @EntityField(name = "关系开始端中文名", type = ApiParamType.STRING)
//    private String fromCnName;
//    @EntityField(name = "关系结束端中文名", type = ApiParamType.STRING)
//    private String toCnName;
//    @EntityField(name = "关系开始端英文名", type = ApiParamType.STRING)
//    private String fromEnName;
//    @EntityField(name = "关系结束端英文名", type = ApiParamType.STRING)
//    private String toEnName;
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

//    public String getFromCnName() {
//        return fromCnName;
//    }
//
//    public void setFromCnName(String fromCnName) {
//        this.fromCnName = fromCnName;
//    }
//
//    public String getToCnName() {
//        return toCnName;
//    }
//
//    public void setToCnName(String toCnName) {
//        this.toCnName = toCnName;
//    }
//
//    public String getFromEnName() {
//        return fromEnName;
//    }
//
//    public void setFromEnName(String fromEnName) {
//        this.fromEnName = fromEnName;
//    }
//
//    public String getToEnName() {
//        return toEnName;
//    }
//
//    public void setToEnName(String toEnName) {
//        this.toEnName = toEnName;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
