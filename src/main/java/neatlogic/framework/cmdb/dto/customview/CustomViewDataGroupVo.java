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

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BasePageVo;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomViewDataGroupVo extends BasePageVo implements Serializable {
    @EntityField(name = "属性uuid", type = ApiParamType.STRING)
    private String attrUuid;
    @EntityField(name = "属性别名", type = ApiParamType.STRING)
    private String attrAlias;
    @EntityField(name = "属性值", type = ApiParamType.STRING)
    private String value;
    @EntityField(name = "属性值hash", type = ApiParamType.STRING)
    private String valueHash;
    @EntityField(name = "条目数量", type = ApiParamType.STRING)
    private int count;
    @EntityField(name = "值过滤列表", type = ApiParamType.JSONARRAY)
    private List<CustomViewValueFilterVo> filterList;

    public void addValueFilter(CustomViewValueFilterVo filterVo) {
        if (CollectionUtils.isEmpty(filterList)) {
            filterList = new ArrayList<>();
        }
        filterList.add(filterVo);
    }

    public String getValueHash() {
        return valueHash;
    }

    public void setValueHash(String valueHash) {
        this.valueHash = valueHash;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public String getAttrUuid() {
        return attrUuid;
    }

    public void setAttrUuid(String attrUuid) {
        this.attrUuid = attrUuid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getAttrAlias() {
        return attrAlias;
    }

    public void setAttrAlias(String attrAlias) {
        this.attrAlias = attrAlias;
    }

    public List<CustomViewValueFilterVo> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<CustomViewValueFilterVo> filterList) {
        this.filterList = filterList;
    }
}
