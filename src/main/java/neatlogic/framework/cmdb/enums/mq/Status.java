/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.enums.mq;

public enum Status {
    ERROR("error", "异常"),
    PENDING("pending", "已就绪"),
    READY("running", "订阅中");

    private final String status;
    private final String text;

    Status(String _status, String _text) {
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
        for (Status s : Status.values()) {
            if (s.getValue().equals(_status)) {
                return s.getText();
            }
        }
        return "";
    }


}
