/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.customview;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;

public class CustomViewConditionFilterVo implements Serializable {
    private String attrUuid;
    private String expression;// 用户sql查询的表达式
    private JSONArray valueList;

    public CustomViewConditionFilterVo() {

    }

    public CustomViewConditionFilterVo(String _attrUuid, String _expression, JSONArray _valueList) {
        this.attrUuid = _attrUuid;
        this.expression = _expression;
        this.valueList = _valueList;
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
