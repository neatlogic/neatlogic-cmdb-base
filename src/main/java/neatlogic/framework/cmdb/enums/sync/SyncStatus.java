/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.enums.sync;

public enum SyncStatus {
    DOING("doing", "同步中"),
    DONE("done", "已完成");

    private final String status;
    private final String text;

    SyncStatus(String _status, String _text) {
        this.status = _status;
        this.text = _text;
    }

    public String getValue() {
        return status;
    }

    public String getText() {
        return text;
    }


    public static String getText(String _status) {
        for (SyncStatus s : SyncStatus.values()) {
            if (s.getValue().equals(_status)) {
                return s.getText();
            }
        }
        return "";
    }

}
