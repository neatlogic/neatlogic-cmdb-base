/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
