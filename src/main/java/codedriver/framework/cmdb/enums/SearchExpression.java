/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.enums;

public enum SearchExpression {
    EQ("eq", "equal", "等于"),
    // LT("lt", "less-than", "小于"),
    // GT("gt", "greater-than", "大于"),
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
        return text;
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
