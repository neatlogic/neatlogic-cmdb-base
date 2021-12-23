/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

// Generated from /Users/chenqiwei/idea_project/codedriver/codedriver-cmdb-base/src/main/resources/CmdbDSL.g4 by ANTLR 4.9.2

package codedriver.framework.cmdb.dsl.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CmdbDSLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface CmdbDSLVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by the {@code expressionJoin}
     * labeled alternative in {@link CmdbDSLParser#expressions}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExpressionJoin(CmdbDSLParser.ExpressionJoinContext ctx);

    /**
     * Visit a parse tree produced by the {@code expression}
     * labeled alternative in {@link CmdbDSLParser#expressions}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExpression(CmdbDSLParser.ExpressionContext ctx);

    /**
     * Visit a parse tree produced by the {@code expressionGroup}
     * labeled alternative in {@link CmdbDSLParser#expressions}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExpressionGroup(CmdbDSLParser.ExpressionGroupContext ctx);

    /**
     * Visit a parse tree produced by {@link CmdbDSLParser#attrs}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAttrs(CmdbDSLParser.AttrsContext ctx);

    /**
     * Visit a parse tree produced by {@link CmdbDSLParser#logicalOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLogicalOperator(CmdbDSLParser.LogicalOperatorContext ctx);

    /**
     * Visit a parse tree produced by {@link CmdbDSLParser#comparisonOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitComparisonOperator(CmdbDSLParser.ComparisonOperatorContext ctx);
}