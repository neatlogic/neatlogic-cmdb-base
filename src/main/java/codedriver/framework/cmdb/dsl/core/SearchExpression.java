/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dsl.core;

import net.sf.jsqlparser.expression.DoubleValue;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.operators.relational.*;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * dsl查询单元：a == 1或 a=1 && b=1或带括号的表达式都算一个查询单元，查询单元将组成树形关系，方便生成最终的表达式
 */
public class SearchExpression {
    public enum Type {
        JOIN, EXPRESSION;
    }

    public enum ValueType {
        NUMBER, STRING;
    }

    private Type type;
    private String attr;
    private String value;
    private ValueType valueType;
    private String logicalOperator;
    private String comparisonOperator;
    private final List<SearchExpression> children = new ArrayList<>();
    private SearchExpression parent;
    //如果是join类型才会有leftExpression和rightExpression
    private SearchExpression leftExpression;
    private SearchExpression rightExpression;

    public SearchExpression(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public ComparisonOperator getComparisonExpression() {
        if (this.comparisonOperator.equals("==")) {
            return new EqualsTo();
        } else if (this.comparisonOperator.equals(">")) {
            return new GreaterThan();
        } else if (this.comparisonOperator.equals(">=")) {
            return new GreaterThanEquals();
        } else if (this.comparisonOperator.equals("<")) {
            return new MinorThan();
        } else if (this.comparisonOperator.equals("<=")) {
            return new MinorThanEquals();
        }
        return null;
    }

    public Expression getExpressionValue() {
        if (StringUtils.isNotBlank(value)) {
            if (value.contains(".")) {
                try {
                    return new DoubleValue(value);
                } catch (Exception ex) {
                    return new StringValue(value);
                }
            } else {
                try {
                    return new LongValue(value);
                } catch (Exception ex) {
                    return new StringValue(value);
                }
            }
        }
        return null;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLogicalOperator() {
        return logicalOperator;
    }

    public void setLogicalOperator(String logicalOperator) {
        this.logicalOperator = logicalOperator;
    }

    public String getComparisonOperator() {
        return comparisonOperator;
    }

    public void setComparisonOperator(String comparisonOperator) {
        this.comparisonOperator = comparisonOperator;
    }

    public List<SearchExpression> getChildren() {
        return children;
    }

    public void addChildren(SearchExpression children) {
        this.children.add(children);
        children.parent = this;
    }

    public SearchExpression getParent() {
        return parent;
    }

    public void setParent(SearchExpression parent) {
        this.parent = parent;
        parent.children.add(this);
    }

    public SearchExpression getLeftExpression() {
        return leftExpression;
    }

    public void setLeftExpression(SearchExpression leftExpression) {
        this.leftExpression = leftExpression;
    }

    public SearchExpression getRightExpression() {
        return rightExpression;
    }

    public void setRightExpression(SearchExpression rightExpression) {
        this.rightExpression = rightExpression;
    }

    public ValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }
}
