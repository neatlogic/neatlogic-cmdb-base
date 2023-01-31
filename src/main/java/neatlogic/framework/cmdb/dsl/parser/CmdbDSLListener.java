/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

// Generated from /Users/chenqiwei/idea_project/neatlogic/neatlogic-cmdb-base/src/main/resources/CmdbDSL.g4 by ANTLR 4.9.2

    package neatlogic.framework.cmdb.dsl.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CmdbDSLParser}.
 */
public interface CmdbDSLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CmdbDSLParser#calculateExpressions}.
	 *
	 * @param ctx the parse tree
	 */
	void enterCalculateExpressions(CmdbDSLParser.CalculateExpressionsContext ctx);

	/**
	 * Exit a parse tree produced by {@link CmdbDSLParser#calculateExpressions}.
	 *
	 * @param ctx the parse tree
	 */
	void exitCalculateExpressions(CmdbDSLParser.CalculateExpressionsContext ctx);

	/**
	 * Enter a parse tree produced by the {@code expressionJoin}
	 * labeled alternative in {@link CmdbDSLParser#expressions}.
	 *
	 * @param ctx the parse tree
	 */
	void enterExpressionJoin(CmdbDSLParser.ExpressionJoinContext ctx);

	/**
	 * Exit a parse tree produced by the {@code expressionJoin}
	 * labeled alternative in {@link CmdbDSLParser#expressions}.
	 *
	 * @param ctx the parse tree
	 */
	void exitExpressionJoin(CmdbDSLParser.ExpressionJoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expression}
	 * labeled alternative in {@link CmdbDSLParser#expressions}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CmdbDSLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expression}
	 * labeled alternative in {@link CmdbDSLParser#expressions}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CmdbDSLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionGroup}
	 * labeled alternative in {@link CmdbDSLParser#expressions}.
	 * @param ctx the parse tree
	 */
	void enterExpressionGroup(CmdbDSLParser.ExpressionGroupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionGroup}
	 * labeled alternative in {@link CmdbDSLParser#expressions}.
	 * @param ctx the parse tree
	 */
	void exitExpressionGroup(CmdbDSLParser.ExpressionGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmdbDSLParser#attrs}.
	 * @param ctx the parse tree
	 */
	void enterAttrs(CmdbDSLParser.AttrsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmdbDSLParser#attrs}.
	 * @param ctx the parse tree
	 */
	void exitAttrs(CmdbDSLParser.AttrsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmdbDSLParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOperator(CmdbDSLParser.LogicalOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmdbDSLParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOperator(CmdbDSLParser.LogicalOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmdbDSLParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(CmdbDSLParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmdbDSLParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(CmdbDSLParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmdbDSLParser#calculateOperator}.
	 * @param ctx the parse tree
	 */
	void enterCalculateOperator(CmdbDSLParser.CalculateOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmdbDSLParser#calculateOperator}.
	 * @param ctx the parse tree
	 */
	void exitCalculateOperator(CmdbDSLParser.CalculateOperatorContext ctx);
}