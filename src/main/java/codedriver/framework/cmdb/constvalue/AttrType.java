package codedriver.framework.cmdb.constvalue;

public enum AttrType {
    PROPERTY("property", "属性定义"), EXPRESSION("expression", "表达式"), CUSTOM("custom", "自定义"),
    BASIC("basic", "基础属性");

    private final String value;
    private final String text;

    AttrType(String _value, String _text) {
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
        for (AttrType s : AttrType.values()) {
            if (s.getValue().equals(_status)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getText(String name) {
        for (AttrType s : AttrType.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }
}
