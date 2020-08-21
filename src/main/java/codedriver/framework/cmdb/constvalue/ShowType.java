package codedriver.framework.cmdb.constvalue;

public enum ShowType {

    NONE("none", "不显示"), LIST("list", "仅列表"), ALL("all", "全展示"), DETAIL("detail", "仅明细");

    private String value;
    private String text;

    private ShowType(String _value, String _text) {
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
        for (ShowType s : ShowType.values()) {
            if (s.getValue().equals(_status)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getText(String name) {
        for (ShowType s : ShowType.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }
}
