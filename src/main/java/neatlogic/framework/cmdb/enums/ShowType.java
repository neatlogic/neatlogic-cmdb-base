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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.common.constvalue.IEnum;
import neatlogic.framework.util.$;

import java.util.List;

/** 定义字段在列表和明细中的显示范围，展示文案按当前请求语言翻译。 */
public enum ShowType implements IEnum {

    NONE("none", "cmdb.showtype.none"),
    LIST("list", "cmdb.showtype.list"),
    ALL("all", "cmdb.showtype.all"),
    DETAIL("detail", "cmdb.showtype.detail");

    private final String value;
    private final String text;

    ShowType(String _value, String _text) {
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
        for (ShowType s : ShowType.values()) {
            if (s.getValue().equals(_status)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getText(String name) {
        for (ShowType s : ShowType.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }


    @Override
    public List getValueTextList() {
        JSONArray array = new JSONArray();
        for (ShowType type : ShowType.values()) {
            array.add(new JSONObject() {
                {
                    this.put("value", type.getValue());
                    this.put("text", type.getText());
                }
            });
        }
        return array;
    }
}
