package codedriver.framework.cmdb.constvalue;

public enum SearchExpression {
    EQ("eq", "=", "等于"), LT("lt", "<", "小于"), GT("gt", ">", "大于"), LE("le", "<=", "小于等于"), GE("ge", ">=", "大于等于"),
    NE("ne", "!=", "不等于"), NL("nl", "not like", "不包含"), LI("li", "like", "包含"), NULL("null", "null", "为空"),
    NOTNULL("notnull", "not null", "不为空");

    private String value;
    private String text;
    private String expression;

    private SearchExpression(String _value, String _expression, String _text) {
        this.value = _value;
        this.text = _text;
        this.expression = _expression;
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
}
