package codedriver.framework.cmdb.constvalue;

public enum GroupType {
    MATAIN("matain", "维护群组"), READONLY("readonly", "消费群组");

    private String value;
    private String text;

    private GroupType(String _value, String _text) {
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
        for (GroupType s : GroupType.values()) {
            if (s.getValue().equals(_status)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getText(String name) {
        for (GroupType s : GroupType.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }
}
