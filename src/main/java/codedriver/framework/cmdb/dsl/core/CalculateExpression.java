/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dsl.core;

import java.util.ArrayList;
import java.util.List;

/**
 * dsl计算单元
 */
public class CalculateExpression {
    public enum Type {
        NUMBER, ATTR, CALCULATE
    }

    private String calculateOperator;
    private final List<CalculateExpression> children = new ArrayList<>();
    private CalculateExpression parent;
    private Type type;
    private CalculateExpression leftExpression;
    private CalculateExpression rightExpression;

    public CalculateExpression(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }


    public String getCalculateOperator() {
        return calculateOperator;
    }

    public void setCalculateOperator(String calculateOperator) {
        this.calculateOperator = calculateOperator;
    }

    public List<CalculateExpression> getChildren() {
        return children;
    }

    public CalculateExpression getParent() {
        return parent;
    }

    public void setParent(CalculateExpression parent) {
        this.parent = parent;
    }

    public CalculateExpression getLeftExpression() {
        return leftExpression;
    }

    public void setLeftExpression(CalculateExpression leftExpression) {
        this.leftExpression = leftExpression;
    }

    public CalculateExpression getRightExpression() {
        return rightExpression;
    }

    public void setRightExpression(CalculateExpression rightExpression) {
        this.rightExpression = rightExpression;
    }
}
