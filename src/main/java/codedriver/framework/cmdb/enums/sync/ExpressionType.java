/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.enums.sync;

public enum ExpressionType {
    IS("is", "等于", true),
    IN("in", "包含", true),
    ISNULL("isnull", "为空", false),
    ISNOTNULL("isnotnull", "不为空", false),
    GT("gt", "大于", true),
    LT("lt", "小于", true),
    GTE("gte", "大于等于", true),
    LTE("lte", "小于等于", true);
    private final String type;
    private final String text;
    private final Boolean needValue;

    ExpressionType(String _type, String _text, Boolean _needValue) {
        this.type = _type;
        this.text = _text;
        this.needValue = _needValue;
    }

    public String getValue() {
        return type;
    }

    public String getText() {
        return text;
    }

    public Boolean getNeedValue() {
        return needValue;
    }
}
