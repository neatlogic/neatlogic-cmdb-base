/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.cmdb.enums;

import neatlogic.framework.util.$;

public enum CiAuthType {
    CIENTITYINSERT("cientityinsert", "配置项添加"),
    CIENTITYUPDATE("cientityupdate", "配置项更新"),
    CIENTITYDELETE("cientitydelete", "配置项删除"),
    CIENTITYQUERY("cientityquery", "配置项查询"),
    CIMANAGE("cimanage", "模型管理"),
    TRANSACTIONMANAGE("transactionmanage", "事务管理"),
    CIENTITYRECOVER("cientityrecover", "配置项恢复"),
    ACCOUNTMANAGEMENT("accountmanagement", "账号管理"),
    PASSWORDVIEW("passwordview", "密码字段查看");

    private final String value;
    private final String text;

    CiAuthType(String _value, String _text) {
        this.value = _value;
        this.text = _text;
    }

    public static CiAuthType get(String _value) {
        for (CiAuthType s : CiAuthType.values()) {
            if (s.getValue().equals(_value)) {
                return s;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return $.t(text);
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
