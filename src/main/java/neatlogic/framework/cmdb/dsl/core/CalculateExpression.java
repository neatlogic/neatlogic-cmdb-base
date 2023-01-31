/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.dsl.core;

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
    private final Type type;
    private String number;
    private String attrs;
    //括号中的表达式
    private CalculateExpression parenthesisExpression;
    //左表达式
    private CalculateExpression leftExpression;
    //右表达式
    private CalculateExpression rightExpression;

    public CalculateExpression(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAttrs() {
        return attrs;
    }

    public void setAttrs(String attrs) {
        this.attrs = attrs;
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
        leftExpression.parent = this;
    }

    public CalculateExpression getRightExpression() {
        return rightExpression;
    }

    public void setRightExpression(CalculateExpression rightExpression) {
        this.rightExpression = rightExpression;
        rightExpression.parent = this;
    }

    public CalculateExpression getParenthesisExpression() {
        return parenthesisExpression;
    }

    public void setParenthesisExpression(CalculateExpression parenthesisExpression) {
        this.parenthesisExpression = parenthesisExpression;
        parenthesisExpression.parent = this;
    }
}
