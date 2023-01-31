/*
 * Copyright(c) 2023 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.enums.sync;

import neatlogic.framework.cmdb.enums.BatchImportStatus;

public enum FieldType {
    STRING("string", "字符串"), DATETIME("datetime", "日期"), DOCUMENT("document", "文档"), INTEGER("integer", "整型"), INT("int", "整型"),
    FLOAT("float", "单精度");
    private final String type;
    private final String text;

    FieldType(String _type, String _text) {
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
        for (BatchImportStatus s : BatchImportStatus.values()) {
            if (s.getValue().equals(name)) {
                return s.getValue();
            }
        }
        return null;
    }

}
