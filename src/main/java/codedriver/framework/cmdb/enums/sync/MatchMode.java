/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.enums.sync;

public enum MatchMode {
    KEY("key", "节点名称"), LEVEL("level", "层次关系");
    private final String type;
    private final String text;

    MatchMode(String _type, String _text) {
        this.type = _type;
        this.text = _text;
    }

    public String getValue() {
        return type;
    }

    public String getText() {
        return text;
    }

    public static String getText(String name) {
        for (MatchMode s : MatchMode.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return null;
    }
}
