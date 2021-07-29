/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.enums.sync;

import codedriver.framework.cmdb.enums.BatchImportStatus;

public enum ExecType {
    PAGE("page", "页面"), CRON("cron", "定时"), REST("rest", "接口");
    private final String type;
    private final String text;

    ExecType(String _type, String _text) {
        this.type = _type;
        this.text = _text;
    }

    public String getValue() {
        return type;
    }

    public String getText() {
        return text;
    }

    public static String getValue(String name) {
        for (ExecType s : ExecType.values()) {
            if (s.getValue().equals(name)) {
                return s.getValue();
            }
        }
        return null;
    }
}
