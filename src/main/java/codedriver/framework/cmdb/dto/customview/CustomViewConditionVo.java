/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.customview;

import codedriver.framework.asynchronization.threadlocal.TenantContext;
import codedriver.framework.cmdb.enums.customview.SearchMode;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BasePageVo;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * 检索条件实体类
 */
public class CustomViewConditionVo extends BasePageVo implements Serializable {
    @EntityField(name = "视图id", type = ApiParamType.LONG)
    private Long customViewId;
    private transient String keyword;
    @JSONField(serialize = false)
    //属性过滤列表，搜索时用
    private transient List<CustomViewConditionFilterVo> attrFilterList;
    @EntityField(name = "搜索模式，normal或group", type = ApiParamType.ENUM, member = SearchMode.class)
    private String searchMode = SearchMode.NORMAL.getValue();
    private transient String viewName;
    private List<CustomViewConditionFieldVo> fieldList;
    @EntityField(name = "分组属性uuid", type = ApiParamType.STRING)
    private String groupBy;
    @JSONField(serialize = false)
    //值过滤列表，分组显示时用
    private transient List<CustomViewValueFilterVo> valueFilterList;
    private Long ciEntityId;//查询单个配置项档案时用

    public Long getCiEntityId() {
        return ciEntityId;
    }

    public void setCiEntityId(Long ciEntityId) {
        this.ciEntityId = ciEntityId;
    }

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

    public String getSearchMode() {
        return searchMode;
    }

    public void setSearchMode(String searchMode) {
        this.searchMode = searchMode;
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

    public List<CustomViewConditionFieldVo> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<CustomViewConditionFieldVo> fieldList) {
        this.fieldList = fieldList;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    public List<CustomViewValueFilterVo> getValueFilterList() {
        return valueFilterList;
    }

    public void setValueFilterList(List<CustomViewValueFilterVo> valueFilterList) {
        this.valueFilterList = valueFilterList;
    }
}
