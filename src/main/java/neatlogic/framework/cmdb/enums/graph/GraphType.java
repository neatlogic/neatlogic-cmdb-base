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

package neatlogic.framework.cmdb.enums.graph;

import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.common.constvalue.IEnum;
import neatlogic.framework.util.I18nUtils;

import java.util.ArrayList;
import java.util.List;

public enum GraphType implements IEnum<JSONObject> {
    PRIVATE("private", "enum.cmdb.graphtype.private"),
    PUBLIC("public", "enum.cmdb.graphtype.public"),
    SCENE("scene", "enum.cmdb.graphtype.scene");

    private final String value;
    private final String text;

    GraphType(String _value, String _text) {
        this.value = _value;
        this.text = _text;
    }

    @Override
    public List<JSONObject> getValueTextList() {
        List<JSONObject> array = new ArrayList<>();
        for (GraphType status : GraphType.values()) {
            array.add(new JSONObject() {
                {
                    this.put("value", status.getValue());
                    this.put("text", status.getText());
                }
            });
        }
        return array;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return I18nUtils.getMessage(text);
    }

    public static String getText(String name) {
        for (GraphType s : GraphType.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }
}