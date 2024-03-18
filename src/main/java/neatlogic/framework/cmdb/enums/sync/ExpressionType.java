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

package neatlogic.framework.cmdb.enums.sync;

import neatlogic.framework.util.$;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ExpressionType {
    IS("is", "等于", true, new String[]{"String", "float", "int"}),
    NE("ne", "不等于", true, new String[]{"String", "float", "int"}),
    IN("in", "包含", true, new String[]{"String"}),
    NOTIN("notin", "不包含", true, new String[]{"String"}),
    //ISNULL("isnull", "为空", false, new String[]{"String", "float", "int"}),
    //ISNOTNULL("isnotnull", "不为空", false, new String[]{"String", "float", "int"}),
    GT("gt", "大于", true, new String[]{"float", "int"}),
    LT("lt", "小于", true, new String[]{"float", "int"}),
    GTE("gte", "大于等于", true, new String[]{"float", "int"}),
    LTE("lte", "小于等于", true, new String[]{"float", "int"});
    private final String type;
    private final String text;
    private final Boolean needValue;
    private final String[] supportType;

    ExpressionType(String _type, String _text, Boolean _needValue, String[] _supportType) {
        this.type = _type;
        this.text = _text;
        this.needValue = _needValue;
        this.supportType = _supportType;
    }

    public static List<ExpressionType> getExpressionBySupportType(String type) {
        List<ExpressionType> returnList = new ArrayList<>();
        for (ExpressionType expressionType : ExpressionType.values()) {
            if (Arrays.stream(expressionType.getSupportType()).anyMatch(t -> t.equalsIgnoreCase(type))) {
                returnList.add(expressionType);
            }
        }
        return returnList;
    }

    public String getValue() {
        return type;
    }

    public String getText() {
        return $.t(text);
    }

    public String[] getSupportType() {
        return supportType;
    }

    public Boolean getNeedValue() {
        return needValue;
    }
}
