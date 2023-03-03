/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package neatlogic.framework.cmdb.dsl;

import neatlogic.framework.cmdb.dsl.parser.CmdbDSLBaseVisitor;
import neatlogic.framework.cmdb.dsl.parser.CmdbDSLLexer;
import neatlogic.framework.cmdb.dsl.parser.CmdbDSLParser;
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
