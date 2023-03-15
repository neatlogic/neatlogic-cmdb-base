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
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.util.I18nUtils;

import java.util.List;

public enum PropHandlerType implements IEnum {
    TEXT("text", "enum.cmdb.prophandlertype.text", "ts-code"),
    MTEXT("mtext", "enum.cmdb.prophandlertype.mtext", "ts-bars"),
    DATE("date", "enum.cmdb.prophandlertype.date", "ts-calendar"),
    TEXTAREA("textarea", "enum.cmdb.prophandlertype.textarea", "ts-textmodule"),
    SELECT("select", "enum.cmdb.prophandlertype.select", "ts-list"),
    CHECKBOX("checkbox", "enum.cmdb.prophandlertype.checkbox", "ts-check-square-o"),
    RADIO("radio", "enum.cmdb.prophandlertype.radio", "ts-round-s"),
    FILE("file", "enum.cmdb.prophandlertype.file", "ts-file"),
    URL("url", "enum.cmdb.prophandlertype.url", "ts-link"),
    PASSWORD("password", "enum.cmdb.prophandlertype.password", "ts-eye-close"),
    /*USER("user", "用户", "ts-user"), TEAM("team", "组织", "ts-team"),*/
    TABLE("table", "enum.cmdb.prophandlertype.table", "ts-tablechart");

    private String type;
    private String text;
    private String icon;

    private PropHandlerType(String _type, String _text, String _icon) {
        this.type = _type;
        this.text = _text;
        this.icon = _icon;
    }

    public String getValue() {
        return type;
    }

    public String getText() {
        return I18nUtils.getMessage(text);
    }

    public String getIcon() {
        return icon;
    }

    public static String getValue(String name) {
        for (PropHandlerType s : PropHandlerType.values()) {
            if (s.getValue().equals(name)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getText(String name) {
        for (PropHandlerType s : PropHandlerType.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }

    public static String getIcon(String name) {
        for (PropHandlerType s : PropHandlerType.values()) {
            if (s.getValue().equals(name)) {
                return s.getIcon();
            }
        }
        return "";
    }


    @Override
    public List getValueTextList() {
        JSONArray array = new JSONArray();
        for(PropHandlerType type : PropHandlerType.values()){
            array.add(new JSONObject(){
                {
                    this.put("value",type.getValue());
                    this.put("text",type.getText());
                }
            });
        }
        return array;
    }
}
