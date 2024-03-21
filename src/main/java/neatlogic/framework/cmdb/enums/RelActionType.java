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

public enum RelActionType {
    INSERT("insert", "term.cmdb.append"),//新增关系
    DELETE("delete", "common.delete"),//删除关系
    REPLACE("replace", "term.cmdb.replace"),//用新关系替换成旧关系
    UPDATE("update", "term.cmdb.update");//新关系为空时不做任何处理，新关系不为空时，替换成新的关系数据

    private final String value;
    private final String text;

    RelActionType(String _value, String _text) {
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
        for (RelActionType s : RelActionType.values()) {
            if (s.getValue().equals(_status)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getText(String name) {
        for (RelActionType s : RelActionType.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }
}
