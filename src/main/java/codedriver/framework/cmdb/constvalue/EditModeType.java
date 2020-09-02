package codedriver.framework.cmdb.constvalue;

public enum EditModeType {
    GLOBAL("global", "全局模式"), PARTIAL("partial", "局部模式");

    private String value;
    private String text;

    private EditModeType(String _value, String _text) {
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
        for (EditModeType s : EditModeType.values()) {
            if (s.getValue().equals(_status)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getText(String name) {
        for (EditModeType s : EditModeType.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }
}
