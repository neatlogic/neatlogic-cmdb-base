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

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;

public class CustomViewConditionFilterVo implements Serializable {
    private String attrUuid;
    private String expression;// 用户sql查询的表达式
    private JSONArray valueList;
    private String type;//类型，attr或constattr

    public CustomViewConditionFilterVo() {

    }

    public CustomViewConditionFilterVo(String _attrUuid, String _expression, JSONArray _valueList) {
        this.attrUuid = _attrUuid;
        this.expression = _expression;
        this.valueList = _valueList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAttrUuid() {
        return attrUuid;
    }

    public void setAttrUuid(String attrUuid) {
        this.attrUuid = attrUuid;
    }


    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public JSONArray getValueList() {
        return valueList;
    }

    public void setValueList(JSONArray valueList) {
        this.valueList = valueList;
    }

    /**
     * 数据库读取时通过这个属性取值，只对非引用性属性有效
     *
     * @return 值
     */
    public String getValue() {
        if (CollectionUtils.isNotEmpty(valueList)) {
            return valueList.getString(0);
        }
        return null;
    }
}
