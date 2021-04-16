/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.enums;

public enum RelDirectionType {
    FROM("from", "当前模型处于上游位置"), TO("to", "当前模型处于下游位置");

    private String value;
    private String text;

    private RelDirectionType(String _value, String _text) {
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
        for (RelDirectionType s : RelDirectionType.values()) {
            if (s.getValue().equals(_status)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getText(String name) {
        for (RelDirectionType s : RelDirectionType.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }
}
