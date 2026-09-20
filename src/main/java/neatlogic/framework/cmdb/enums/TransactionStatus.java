/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.cmdb.enums;

import neatlogic.framework.common.constvalue.IEnum;
import neatlogic.framework.common.dto.ValueTextVo;
import neatlogic.framework.util.$;

import java.util.ArrayList;
import java.util.List;

/** 事务审计枚举，展示文案按当前请求语言翻译。 */
public enum TransactionStatus implements IEnum<ValueTextVo> {
    COMMITED("commited", "cmdb.transaction.status.commited"),
    UNCOMMIT("uncommit", "cmdb.transaction.status.uncommit"),
    RECOVER("recover", "cmdb.transaction.status.recover"),
    EXPIRED("expired", "cmdb.transaction.status.expired");

    private final String value;
    private final String text;

    TransactionStatus(String _value, String _text) {
        this.value = _value;
        this.text = _text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return $.t(text);
    }

    public static String getValue(String _status) {
        for (TransactionStatus s : TransactionStatus.values()) {
            if (s.getValue().equals(_status)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getText(String name) {
        for (TransactionStatus s : TransactionStatus.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }

    @Override
    public List<ValueTextVo> getValueTextList() {
        List<ValueTextVo> returnList = new ArrayList<>();
        for (TransactionStatus input : TransactionStatus.values()) {
            returnList.add(new ValueTextVo(input.getValue(), input.getText()));
        }
        return returnList;
    }
}
