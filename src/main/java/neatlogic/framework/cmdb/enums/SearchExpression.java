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

package neatlogic.framework.cmdb.enums;

import neatlogic.framework.util.$;

public enum SearchExpression {
    EQ("eq", "equal", "等于"),
    //LT("lt", "less-than", "小于"),
    //GT("gt", "greater-than", "大于"),
    BT("bt", "between", "在此区间"),
    NE("ne", "notequal", "不等于"),
    NL("nl", "notlike", "不包含"),
    LI("li", "like", "包含"),
    NULL("null", "is-null", "为空"),
    NOTNULL("notnull", "is-not-null", "不为空");

    private final String value;
    private final String text;
    private final String expression;

    SearchExpression(String _value, String _expression, String _text) {
        this.value = _value;
        this.text = _text;
        this.expression = _expression;
    }

    public static SearchExpression get(String value) {
        for (SearchExpression s : SearchExpression.values()) {
            if (s.getValue().equals(value)) {
                return s;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return $.t(text);
    }

    public String getExpression() {
        return expression;
    }

    public static String getValue(String value) {
        for (SearchExpression s : SearchExpression.values()) {
            if (s.getValue().equals(value)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getExpression(String value) {
        for (SearchExpression s : SearchExpression.values()) {
            if (s.getValue().equals(value)) {
                return s.getExpression();
            }
        }
        return null;
    }

    public static String getText(String name) {
        for (SearchExpression s : SearchExpression.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }

    public static boolean checkExpressionIsExists(String expression) {
        for (SearchExpression s : SearchExpression.values()) {
            if (s.getExpression().equals(expression)) {
                return true;
            }
        }
        return false;
    }
}
