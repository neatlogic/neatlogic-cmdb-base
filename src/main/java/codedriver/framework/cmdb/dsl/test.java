/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dsl;

import codedriver.framework.cmdb.dsl.parser.CmdbDSLBaseVisitor;
import codedriver.framework.cmdb.dsl.parser.CmdbDSLLexer;
import codedriver.framework.cmdb.dsl.parser.CmdbDSLParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class test {
    public static void main(String[] argv) {
        CharStream input = CharStreams.fromString("a.b==123");
        CmdbDSLLexer lexer = new CmdbDSLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CmdbDSLParser parser = new CmdbDSLParser(tokens);
        ParseTree tree = parser.expressions();
        TestVisitor visitor = new TestVisitor();
        visitor.visit(tree);
        //System.out.println(tree.toStringTree(parser));
    }

    static class TestVisitor extends CmdbDSLBaseVisitor<String> {
        @Override
        public String visitExpressionJoin(CmdbDSLParser.ExpressionJoinContext ctx) {
            //System.out.println("===expressionJoin");
            //System.out.println("left:" + ctx.expressions(0).getText() + " mid:" + ctx.logicalOperator().getText() + " right:" + ctx.expressions(1).getText());
            return super.visitExpressionJoin(ctx);
        }

        @Override
        public String visitAttrs(CmdbDSLParser.AttrsContext ctx) {
            System.out.println(ctx.getText());
            return visitChildren(ctx);
        }

        @Override
        public String visitExpression(CmdbDSLParser.ExpressionContext ctx) {
            System.out.println(ctx.getText());
            return visitChildren(ctx);
        }
    }

}
