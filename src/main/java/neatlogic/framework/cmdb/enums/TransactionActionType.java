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

import neatlogic.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.util.I18nUtils;

import java.util.ArrayList;
import java.util.List;

public enum TransactionActionType implements IEnum<JSONObject> {
    INSERT("insert", "enum.cmdb.transactionactiontype.insert"),
    UPDATE("update", "enum.cmdb.transactionactiontype.update"),
    DELETE("delete", "enum.cmdb.transactionactiontype.delete"),
    RECOVER("recover", "enum.cmdb.transactionactiontype.recover"),
    VIEW("view", "enum.cmdb.transactionactiontype.view");

    private final String value;
    private final String text;

    private TransactionActionType(String _value, String _text) {
        this.value = _value;
        this.text = _text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return I18nUtils.getMessage(text);
    }

    public static String getValue(String _status) {
        for (TransactionActionType s : TransactionActionType.values()) {
            if (s.getValue().equals(_status)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getText(String name) {
        for (TransactionActionType s : TransactionActionType.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }

    @Override
    public List<JSONObject> getValueTextList() {
        List<JSONObject> returnList = new ArrayList<>();
        for (TransactionActionType input : TransactionActionType.values()) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("value", input.getValue());
            jsonObj.put("text", input.getText());
            returnList.add(jsonObj);
        }
        return returnList;
    }
}