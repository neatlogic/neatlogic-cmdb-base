package codedriver.framework.cmdb.constvalue;

public enum SearchExpression {
    EQ("eq", "include", "等于"),
    LT("lt", "less-than", "小于"), 
    GT("gt", "greater-than", "大于"),
    NE("ne", "exclude", "不等于"),
    NL("nl", "notlike", "不包含"), 
    LI("li", "like", "包含"),
    NULL("null", "is-null", "为空"),
    NOTNULL("notnull", "is-not-null", "不为空");

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
