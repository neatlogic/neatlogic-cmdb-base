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

package neatlogic.framework.cmdb.enums.sync;

import neatlogic.framework.util.$;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ExpressionType {
    IS("is", "nmc.search.expression.equal", true, new String[]{"String", "float", "int"}),
    NE("ne", "nmc.search.expression.notequal", true, new String[]{"String", "float", "int"}),
    IN("in", "nmc.search.expression.contains", true, new String[]{"String"}),
    NOTIN("notin", "nmc.search.expression.notcontains", true, new String[]{"String"}),
    //ISNULL("isnull", "为空", false, new String[]{"String", "float", "int"}),
    //ISNOTNULL("isnotnull", "不为空", false, new String[]{"String", "float", "int"}),
    GT("gt", "nmc.search.expression.greater", true, new String[]{"float", "int"}),
    LT("lt", "nmc.search.expression.less", true, new String[]{"float", "int"}),
    GTE("gte", "nmc.search.expression.greaterorequal", true, new String[]{"float", "int"}),
    LTE("lte", "nmc.search.expression.lessorequal", true, new String[]{"float", "int"});
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
