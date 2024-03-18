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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.common.constvalue.IEnum;
import neatlogic.framework.util.$;

import java.util.List;

public enum PropHandlerType implements IEnum {
    TEXT("text", "文本框", "ts-code"),
    MTEXT("mtext", "多文本框", "ts-bars"),
    DATE("date", "日期", "ts-calendar"),
    TEXTAREA("textarea", "文本域", "ts-textmodule"),
    SELECT("select", "下拉框", "ts-list"),
    CHECKBOX("checkbox", "复选框", "ts-check-square-o"),
    RADIO("radio", "单选框", "ts-round-s"),
    FILE("file", "附件", "ts-file"),
    URL("url", "链接", "ts-link"),
    PASSWORD("password", "密码", "ts-eye-close"),
    /*USER("user", "用户", "ts-user"), TEAM("team", "组织", "ts-team"),*/
    TABLE("table", "表格", "ts-tablechart");

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
        return $.t(text);
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
