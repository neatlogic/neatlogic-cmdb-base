package codedriver.framework.cmdb.constvalue;

/**
 * @Title: BasicAttr
 * @Package: codedriver.framework.cmdb.constvalue
 * @Description: 基础属性
 * @author: chenqiwei
 * @date: 2021/3/179:49 上午
 * Copyright(c) 2021 TechSure Co.,Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 **/
public enum BasicAttr {
    name("name", "名称"), ip("ip", "IP"), port("port", "端口");

    private final String value;
    private final String text;

    BasicAttr(String _value, String _text) {
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
        for (BasicAttr s : BasicAttr.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }
}
