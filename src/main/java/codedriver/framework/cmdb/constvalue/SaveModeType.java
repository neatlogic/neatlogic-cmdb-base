package codedriver.framework.cmdb.constvalue;

public enum SaveModeType {
    REPLACE("replace", "替换模式"), MERGE("merge", "合并模式");

    private String value;
    private String text;

    private SaveModeType(String _value, String _text) {
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
        for (SaveModeType s : SaveModeType.values()) {
            if (s.getValue().equals(_status)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getText(String name) {
        for (SaveModeType s : SaveModeType.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }
}
