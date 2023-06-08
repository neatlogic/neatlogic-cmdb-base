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
