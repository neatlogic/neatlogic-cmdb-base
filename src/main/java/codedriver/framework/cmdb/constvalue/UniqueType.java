package codedriver.framework.cmdb.constvalue;

public enum UniqueType {
	TYPE("type", "同类唯一"), GLOBAL("global", "全局唯一");

	private String value;
	private String text;

	private UniqueType(String _value, String _text) {
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
		for (UniqueType s : UniqueType.values()) {
			if (s.getValue().equals(_status)) {
				return s.getValue();
			}
		}
		return null;
	}

	public static String getText(String name) {
		for (UniqueType s : UniqueType.values()) {
			if (s.getValue().equals(name)) {
				return s.getText();
			}
		}
		return "";
	}
}
