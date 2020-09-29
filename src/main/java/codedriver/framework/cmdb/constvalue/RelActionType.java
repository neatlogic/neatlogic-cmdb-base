package codedriver.framework.cmdb.constvalue;

public enum RelActionType {
    INSERT("insert", "新增"), DELETE("delete", "删除");

    private String value;
    private String text;

    private RelActionType(String _value, String _text) {
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
        for (RelActionType s : RelActionType.values()) {
            if (s.getValue().equals(_status)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getText(String name) {
        for (RelActionType s : RelActionType.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }
}
