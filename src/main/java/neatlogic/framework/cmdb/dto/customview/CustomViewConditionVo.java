/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.cmdb.dto.customview;

import neatlogic.framework.asynchronization.threadlocal.TenantContext;
import neatlogic.framework.cmdb.enums.customview.SearchMode;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BasePageVo;
import neatlogic.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.List;

/**
 * 检索条件实体类
 */
public class CustomViewConditionVo extends BasePageVo {
    @EntityField(name = "视图id", type = ApiParamType.LONG)
    private Long customViewId;
    @JSONField(serialize = false)
    //属性过滤列表，搜索时用
    private List<CustomViewConditionFilterVo> attrFilterList;
    @EntityField(name = "搜索模式，normal或group", type = ApiParamType.ENUM, member = SearchMode.class)
    private String searchMode = SearchMode.NORMAL.getValue();
    @JSONField(serialize = false)
    private String viewName;
    private List<CustomViewConditionFieldVo> fieldList;
    @EntityField(name = "分组属性uuid", type = ApiParamType.STRING)
    private String groupBy;
    @JSONField(serialize = false)
    //值过滤列表，分组显示时用
    private List<CustomViewValueFilterVo> valueFilterList;
    private Long ciEntityId;//查询单个配置项档案时用

    private Integer limit = 10000;//最多返回10000数据，用在count查询

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

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

    public void addAttrFilter(CustomViewConditionFilterVo filter) {
        if (this.attrFilterList == null) {
            this.attrFilterList = new ArrayList<>();
        }
        this.attrFilterList.add(filter);
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
