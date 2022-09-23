/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.group;

import com.alibaba.fastjson.JSONArray;

import java.io.Serializable;

public class ConditionVo implements Serializable {
    private enum Expression {
        EQUAL("equal", " %s == %s "),
        NOTEQUAL("notequal", " not %s contains %s "),
        NOTLIKE("notlike", " %s = %s "),
        LIKE("like", " not %s = %s "),
        ISNULL("is-null", " %s contains any ( %s ) "),
        ISNOTNULL("is-not-null", " not %s contains any ( %s ) ");
        private final String name;
        private final String expression;

        public String getName() {
            return name;
        }

        public String getExpression() {
            return expression;
        }

        Expression(String _name, String _expression) {
            this.name = _name;
            this.expression = _expression;
        }


    }

    private String uuid;
    private String id;
    private String type;
    private String expression;
    private JSONArray valueList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String buildScript() {
        return "calculate('" + expression + "', data['" + this.getId() + "'], condition['" + this.getUuid() + "'], define['" + this.getId() + "'])";
    }


}
