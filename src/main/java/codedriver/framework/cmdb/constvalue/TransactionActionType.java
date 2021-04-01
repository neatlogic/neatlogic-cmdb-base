package codedriver.framework.cmdb.constvalue;

public enum TransactionActionType {
    INSERT("insert", "新增"), UPDATE("update", "修改"), DELETE("delete", "删除"), RECOVER("recover", "恢复");

    private final String value;
    private final String text;

    private TransactionActionType(String _value, String _text) {
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
        for (TransactionActionType s : TransactionActionType.values()) {
            if (s.getValue().equals(_status)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getText(String name) {
        for (TransactionActionType s : TransactionActionType.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }
}
