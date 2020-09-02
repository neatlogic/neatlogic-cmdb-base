package codedriver.framework.cmdb.constvalue;

public enum TransactionStatus {
    COMMITED("commited", "已提交"), UNCOMMIT("uncommit", "未提交");

    private String value;
    private String text;

    private TransactionStatus(String _value, String _text) {
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
