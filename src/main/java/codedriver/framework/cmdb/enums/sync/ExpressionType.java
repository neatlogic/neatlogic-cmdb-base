/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.enums.sync;

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
        return text;
    }

    public String[] getSupportType() {
        return supportType;
    }

    public Boolean getNeedValue() {
        return needValue;
    }
}
