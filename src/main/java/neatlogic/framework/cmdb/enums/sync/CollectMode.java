/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.enums.sync;

public enum CollectMode {
    INITIATIVE("initiative", "主动采集"), PASSIVE("passive", "被动采集");
    private final String type;
    private final String text;

    CollectMode(String _type, String _text) {
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
        for (CollectMode s : CollectMode.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return null;
    }
}
