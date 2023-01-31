/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.enums.customview;

public enum RelType {
    ATTR("attr", "属性"), CI("ci", "模型"), REL("rel", "关系"),
    CONST_ATTR("constattr", "内部属性");
    private final String value;
    private final String text;

    RelType(String _value, String _text) {
        this.value = _value;
        this.text = _text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public static String getText(String name) {
        for (RelType s : RelType.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }
}
