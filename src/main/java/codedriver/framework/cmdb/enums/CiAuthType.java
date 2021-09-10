/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.enums;

public enum CiAuthType {
    CIENTITYINSERT("cientityinsert", "配置项添加"), CIENTITYUPDATE("cientityupdate", "配置项更新"),
    CIENTITYDELETE("cientitydelete", "配置项删除"), CIENTITYQUERY("cientityquery", "配置项查询"),
    CIMANAGE("cimanage", "模型管理"),
    TRANSACTIONMANAGE("transactionmanage", "事务管理"),
    CIENTITYRECOVER("cientityrecover", "配置项恢复"),
    PASSWORDVIEW("passwordview", "密码字段查看");

    private final String value;
    private final String text;

    CiAuthType(String _value, String _text) {
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
        for (CiAuthType s : CiAuthType.values()) {
            if (s.getValue().equals(_status)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getText(String name) {
        for (CiAuthType s : CiAuthType.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }
}
