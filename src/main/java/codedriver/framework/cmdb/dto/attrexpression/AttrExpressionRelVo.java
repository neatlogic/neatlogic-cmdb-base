/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.attrexpression;

public class AttrExpressionRelVo {
    private Long expressionCiId;
    private Long expressionAttrId;
    private Long valueCiId;
    private Long valueAttrId;

    public Long getExpressionCiId() {
        return expressionCiId;
    }

    public void setExpressionCiId(Long expressionCiId) {
        this.expressionCiId = expressionCiId;
    }

    public Long getExpressionAttrId() {
        return expressionAttrId;
    }

    public void setExpressionAttrId(Long expressionAttrId) {
        this.expressionAttrId = expressionAttrId;
    }

    public Long getValueCiId() {
        return valueCiId;
    }

    public void setValueCiId(Long valueCiId) {
        this.valueCiId = valueCiId;
    }

    public Long getValueAttrId() {
        return valueAttrId;
    }

    public void setValueAttrId(Long valueAttrId) {
        this.valueAttrId = valueAttrId;
    }
}
