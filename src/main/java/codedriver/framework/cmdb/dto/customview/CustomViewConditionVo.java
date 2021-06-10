/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.customview;

import codedriver.framework.asynchronization.threadlocal.TenantContext;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BasePageVo;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * 检索条件实体类
 */
public class CustomViewConditionVo extends BasePageVo {
    @EntityField(name = "视图id", type = ApiParamType.LONG)
    private Long customViewId;
    private transient String keyword;
    @JSONField(serialize = false)
    private transient List<CustomViewConditionFilterVo> attrFilterList;
    private transient String viewName;
    private List<String> fieldList;

    public Long getCustomViewId() {
        return customViewId;
    }

    public void setCustomViewId(Long customViewId) {
        this.customViewId = customViewId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<CustomViewConditionFilterVo> getAttrFilterList() {
        return attrFilterList;
    }

    public void setAttrFilterList(List<CustomViewConditionFilterVo> attrFilterList) {
        this.attrFilterList = attrFilterList;
    }

    public String getViewName() {
        return TenantContext.get().getDataDbName() + ".customview_" + this.getCustomViewId();
    }

    public List<String> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<String> fieldList) {
        this.fieldList = fieldList;
    }
}
