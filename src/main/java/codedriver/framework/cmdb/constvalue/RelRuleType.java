package codedriver.framework.cmdb.constvalue;

public enum RelRuleType {
    OZ("0:1", "零或一个"), ZN("0:N", "零或多个"), ON("1:N", "一或多个"), OO("1:1", "必须一个");

    private String value;
    private String text;

    private RelRuleType(String _value, String _text) {
        this.value = _value;
        this.text = _text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public static String getValue(String _status) {
        for (RelRuleType s : RelRuleType.values()) {
            if (s.getValue().equals(_status)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getText(String name) {
        for (RelRuleType s : RelRuleType.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }
}
