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

package neatlogic.framework.cmdb.dto.globalattr;

import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.cmdb.enums.SearchExpression;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.ValueTextVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GlobalAttrVo implements Serializable {

    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @JSONField(serialize = false)//id列表
    private List<Long> idList;
    @JSONField(serialize = false)//是否需要返回成员
    private Integer needItem;
    @EntityField(name = "common.uniquename", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "common.name", type = ApiParamType.STRING)
    private String label;
    @EntityField(name = "term.ciview.alias", type = ApiParamType.STRING)
    private String alias;
    @EntityField(name = "common.isactive", type = ApiParamType.INTEGER)
    private Integer isActive;
    @EntityField(name = "common.ismultiple", type = ApiParamType.INTEGER)
    private Integer isMultiple;
    @EntityField(name = "common.description", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "common.sort", type = ApiParamType.INTEGER)
    private int sort;
    @EntityField(name = "term.cmdb.allowedit", type = ApiParamType.INTEGER)
    private Integer allowEdit;
    @EntityField(name = "term.diagram.isprivate", type = ApiParamType.INTEGER)
    private Integer isPrivate;
    @EntityField(name = "支持的搜索表达式列表")
    private List<ValueTextVo> expressionList;

    private List<GlobalAttrItemVo> itemList;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public List<ValueTextVo> getExpressionList() {
        if (CollectionUtils.isEmpty(this.expressionList)) {
            expressionList = new ArrayList<>();
            SearchExpression[] expressions = new SearchExpression[]{SearchExpression.LI, SearchExpression.NL, SearchExpression.NOTNULL, SearchExpression.NULL};
            for (SearchExpression expression : expressions) {
                expressionList.add(new ValueTextVo(expression.getExpression(), expression.getText()));
            }
        }
        return expressionList;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public Integer getAllowEdit() {
        return allowEdit;
    }

    public void setAllowEdit(Integer allowEdit) {
        this.allowEdit = allowEdit;
    }

    public List<GlobalAttrItemVo> getItemList() {
        return itemList;
    }

    public GlobalAttrItemVo getItem(String value) {
        if (StringUtils.isNoneBlank(value) && CollectionUtils.isNotEmpty(this.getItemList())) {
            for (GlobalAttrItemVo item : this.getItemList()) {
                if (item.getValue().equalsIgnoreCase(value)) {
                    return item;
                }
            }
        }
        return null;
    }

    public boolean containItem(String value) {
        if (StringUtils.isNoneBlank(value) && CollectionUtils.isNotEmpty(this.getItemList())) {
            for (GlobalAttrItemVo item : this.getItemList()) {
                if (item.getValue().equalsIgnoreCase(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public Integer getNeedItem() {
        return needItem;
    }

    public void setNeedItem(Integer needItem) {
        this.needItem = needItem;
    }

    public void setItemList(List<GlobalAttrItemVo> itemList) {
        this.itemList = itemList;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Integer getIsMultiple() {
        return isMultiple;
    }

    public void setIsMultiple(Integer isMultiple) {
        this.isMultiple = isMultiple;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Integer isPrivate) {
        this.isPrivate = isPrivate;
    }
}
