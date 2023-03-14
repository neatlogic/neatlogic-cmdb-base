/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package neatlogic.framework.cmdb.enums;

import neatlogic.framework.util.I18nUtils;

public enum CiAuthType {
    CIENTITYINSERT("cientityinsert", "enum.cmdb.ciauthtype.cientityinsert"),
    CIENTITYUPDATE("cientityupdate", "enum.cmdb.ciauthtype.cientityupdate"),
    CIENTITYDELETE("cientitydelete", "enum.cmdb.ciauthtype.cientitydelete"),
    CIENTITYQUERY("cientityquery", "enum.cmdb.ciauthtype.cientityquery"),
    CIMANAGE("cimanage", "enum.cmdb.ciauthtype.cimanage"),
    TRANSACTIONMANAGE("transactionmanage", "enum.cmdb.ciauthtype.transactionmanage"),
    CIENTITYRECOVER("cientityrecover", "enum.cmdb.ciauthtype.cientityrecover"),
    PASSWORDVIEW("passwordview", "enum.cmdb.ciauthtype.passwordview");

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
        return I18nUtils.getMessage(text);
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
