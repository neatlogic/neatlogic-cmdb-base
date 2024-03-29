package neatlogic.framework.cmdb.enums.resourcecenter.condition;

import neatlogic.framework.util.$;

public enum ConditionConfigType {
  DEFAULT("default","默认");

  private final String value;
  private final String name;

  private ConditionConfigType(String _value, String _name) {
    this.value = _value;
    this.name = _name;
  }

  public String getValue() {
    return value;
  }

  public String getName() {
    return $.t(name);
  }

  public static String getValue(String _value) {
    for (ConditionConfigType s : ConditionConfigType.values()) {
      if (s.getValue().equals(_value)) {
        return s.getValue();
      }
    }
    return null;
  }

  public static String getName(String _value) {
    for (ConditionConfigType s : ConditionConfigType.values()) {
      if (s.getValue().equals(_value)) {
        return s.getName();
      }
    }
    return "";
  }
}
