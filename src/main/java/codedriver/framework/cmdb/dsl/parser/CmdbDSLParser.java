/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

// Generated from /Users/chenqiwei/idea_project/codedriver/codedriver-cmdb-base/src/main/resources/CmdbDSL.g4 by ANTLR 4.9.2

package codedriver.framework.cmdb.dsl.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmdbDSLParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, NUMBER_ARRAY = 2, STRING_ARRAY = 3, NUMBER = 4, BRACKET_LEFT = 5, BRACKET_RIGHT = 6,
            AND = 7, OR = 8, EQ = 9, GT = 10, LT = 11, LE = 12, GE = 13, NOTEQ = 14, INCLUDE = 15, EXCLUDE = 16,
            ATTR = 17, STRING = 18, WHITESPACE = 19;
    public static final int
            RULE_expressions = 0, RULE_attrs = 1, RULE_logicalOperator = 2, RULE_comparisonOperator = 3;

    private static String[] makeRuleNames() {
        return new String[]{
                "expressions", "attrs", "logicalOperator", "comparisonOperator"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'.'", null, null, null, "'('", "')'", "'&&'", "'||'", "'=='",
                "'>'", "'<'", "'<='", "'>='", "'!='", "'include'", "'exclude'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, "NUMBER_ARRAY", "STRING_ARRAY", "NUMBER", "BRACKET_LEFT",
                "BRACKET_RIGHT", "AND", "OR", "EQ", "GT", "LT", "LE", "GE", "NOTEQ",
                "INCLUDE", "EXCLUDE", "ATTR", "STRING", "WHITESPACE"
        };
    }

    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "CmdbDSL.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public CmdbDSLParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class ExpressionsContext extends ParserRuleContext {
        public ExpressionsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expressions;
        }

        public ExpressionsContext() {
        }

        public void copyFrom(ExpressionsContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class ExpressionJoinContext extends ExpressionsContext {
        public List<ExpressionsContext> expressions() {
            return getRuleContexts(ExpressionsContext.class);
        }

        public ExpressionsContext expressions(int i) {
            return getRuleContext(ExpressionsContext.class, i);
        }

        public LogicalOperatorContext logicalOperator() {
            return getRuleContext(LogicalOperatorContext.class, 0);
        }

        public ExpressionJoinContext(ExpressionsContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmdbDSLListener) ((CmdbDSLListener) listener).enterExpressionJoin(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmdbDSLListener) ((CmdbDSLListener) listener).exitExpressionJoin(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmdbDSLVisitor)
                return ((CmdbDSLVisitor<? extends T>) visitor).visitExpressionJoin(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ExpressionContext extends ExpressionsContext {
        public AttrsContext attrs() {
            return getRuleContext(AttrsContext.class, 0);
        }

        public ComparisonOperatorContext comparisonOperator() {
            return getRuleContext(ComparisonOperatorContext.class, 0);
        }

        public TerminalNode STRING() {
            return getToken(CmdbDSLParser.STRING, 0);
        }

        public TerminalNode NUMBER() {
            return getToken(CmdbDSLParser.NUMBER, 0);
        }

        public TerminalNode NUMBER_ARRAY() {
            return getToken(CmdbDSLParser.NUMBER_ARRAY, 0);
        }

        public TerminalNode STRING_ARRAY() {
            return getToken(CmdbDSLParser.STRING_ARRAY, 0);
        }

        public ExpressionContext(ExpressionsContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmdbDSLListener) ((CmdbDSLListener) listener).enterExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmdbDSLListener) ((CmdbDSLListener) listener).exitExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmdbDSLVisitor) return ((CmdbDSLVisitor<? extends T>) visitor).visitExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ExpressionGroupContext extends ExpressionsContext {
        public TerminalNode BRACKET_LEFT() {
            return getToken(CmdbDSLParser.BRACKET_LEFT, 0);
        }

        public ExpressionsContext expressions() {
            return getRuleContext(ExpressionsContext.class, 0);
        }

        public TerminalNode BRACKET_RIGHT() {
            return getToken(CmdbDSLParser.BRACKET_RIGHT, 0);
        }

        public ExpressionGroupContext(ExpressionsContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmdbDSLListener) ((CmdbDSLListener) listener).enterExpressionGroup(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmdbDSLListener) ((CmdbDSLListener) listener).exitExpressionGroup(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmdbDSLVisitor)
                return ((CmdbDSLVisitor<? extends T>) visitor).visitExpressionGroup(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExpressionsContext expressions() throws RecognitionException {
        return expressions(0);
    }

    private ExpressionsContext expressions(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        ExpressionsContext _localctx = new ExpressionsContext(_ctx, _parentState);
        ExpressionsContext _prevctx = _localctx;
        int _startState = 0;
        enterRecursionRule(_localctx, 0, RULE_expressions, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(17);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case ATTR: {
                        _localctx = new ExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;

                        setState(9);
                        attrs();
                        setState(10);
                        comparisonOperator();
                        setState(11);
                        _la = _input.LA(1);
                        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER_ARRAY) | (1L << STRING_ARRAY) | (1L << NUMBER) | (1L << STRING))) != 0))) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                    }
                    break;
                    case BRACKET_LEFT: {
                        _localctx = new ExpressionGroupContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(13);
                        match(BRACKET_LEFT);
                        setState(14);
                        expressions(0);
                        setState(15);
                        match(BRACKET_RIGHT);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                _ctx.stop = _input.LT(-1);
                setState(25);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 1, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new ExpressionJoinContext(new ExpressionsContext(_parentctx, _parentState));
                                pushNewRecursionContext(_localctx, _startState, RULE_expressions);
                                setState(19);
                                if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
                                setState(20);
                                logicalOperator();
                                setState(21);
                                expressions(3);
                            }
                        }
                    }
                    setState(27);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 1, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public static class AttrsContext extends ParserRuleContext {
        public List<TerminalNode> ATTR() {
            return getTokens(CmdbDSLParser.ATTR);
        }

        public TerminalNode ATTR(int i) {
            return getToken(CmdbDSLParser.ATTR, i);
        }

        public AttrsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_attrs;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmdbDSLListener) ((CmdbDSLListener) listener).enterAttrs(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmdbDSLListener) ((CmdbDSLListener) listener).exitAttrs(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmdbDSLVisitor) return ((CmdbDSLVisitor<? extends T>) visitor).visitAttrs(this);
            else return visitor.visitChildren(this);
        }
    }

    public final AttrsContext attrs() throws RecognitionException {
        AttrsContext _localctx = new AttrsContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_attrs);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(32);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 2, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(28);
                                match(ATTR);
                                setState(29);
                                match(T__0);
                            }
                        }
                    }
                    setState(34);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 2, _ctx);
                }
                setState(35);
                match(ATTR);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class LogicalOperatorContext extends ParserRuleContext {
        public TerminalNode AND() {
            return getToken(CmdbDSLParser.AND, 0);
        }

        public TerminalNode OR() {
            return getToken(CmdbDSLParser.OR, 0);
        }

        public LogicalOperatorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_logicalOperator;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmdbDSLListener) ((CmdbDSLListener) listener).enterLogicalOperator(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmdbDSLListener) ((CmdbDSLListener) listener).exitLogicalOperator(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmdbDSLVisitor)
                return ((CmdbDSLVisitor<? extends T>) visitor).visitLogicalOperator(this);
            else return visitor.visitChildren(this);
        }
    }

    public final LogicalOperatorContext logicalOperator() throws RecognitionException {
        LogicalOperatorContext _localctx = new LogicalOperatorContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_logicalOperator);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(37);
                _la = _input.LA(1);
                if (!(_la == AND || _la == OR)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ComparisonOperatorContext extends ParserRuleContext {
        public TerminalNode EQ() {
            return getToken(CmdbDSLParser.EQ, 0);
        }

        public TerminalNode GT() {
            return getToken(CmdbDSLParser.GT, 0);
        }

        public TerminalNode LT() {
            return getToken(CmdbDSLParser.LT, 0);
        }

        public TerminalNode LE() {
            return getToken(CmdbDSLParser.LE, 0);
        }

        public TerminalNode GE() {
            return getToken(CmdbDSLParser.GE, 0);
        }

        public TerminalNode NOTEQ() {
            return getToken(CmdbDSLParser.NOTEQ, 0);
        }

        public TerminalNode INCLUDE() {
            return getToken(CmdbDSLParser.INCLUDE, 0);
        }

        public TerminalNode EXCLUDE() {
            return getToken(CmdbDSLParser.EXCLUDE, 0);
        }

        public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_comparisonOperator;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmdbDSLListener) ((CmdbDSLListener) listener).enterComparisonOperator(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmdbDSLListener) ((CmdbDSLListener) listener).exitComparisonOperator(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmdbDSLVisitor)
                return ((CmdbDSLVisitor<? extends T>) visitor).visitComparisonOperator(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
        ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_comparisonOperator);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(39);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << GT) | (1L << LT) | (1L << LE) | (1L << GE) | (1L << NOTEQ) | (1L << INCLUDE) | (1L << EXCLUDE))) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 0:
                return expressions_sempred((ExpressionsContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean expressions_sempred(ExpressionsContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 2);
        }
        return true;
    }

    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25,\4\2\t\2\4\3\t" +
                    "\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\24\n\2\3\2" +
                    "\3\2\3\2\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\3\3\3\7\3!\n\3\f\3\16\3$\13" +
                    "\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\2\3\2\6\2\4\6\b\2\5\4\2\4\6\24\24\3\2\t" +
                    "\n\3\2\13\22\2*\2\23\3\2\2\2\4\"\3\2\2\2\6\'\3\2\2\2\b)\3\2\2\2\n\13\b" +
                    "\2\1\2\13\f\5\4\3\2\f\r\5\b\5\2\r\16\t\2\2\2\16\24\3\2\2\2\17\20\7\7\2" +
                    "\2\20\21\5\2\2\2\21\22\7\b\2\2\22\24\3\2\2\2\23\n\3\2\2\2\23\17\3\2\2" +
                    "\2\24\33\3\2\2\2\25\26\f\4\2\2\26\27\5\6\4\2\27\30\5\2\2\5\30\32\3\2\2" +
                    "\2\31\25\3\2\2\2\32\35\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\3\3\2\2" +
                    "\2\35\33\3\2\2\2\36\37\7\23\2\2\37!\7\3\2\2 \36\3\2\2\2!$\3\2\2\2\" \3" +
                    "\2\2\2\"#\3\2\2\2#%\3\2\2\2$\"\3\2\2\2%&\7\23\2\2&\5\3\2\2\2\'(\t\3\2" +
                    "\2(\7\3\2\2\2)*\t\4\2\2*\t\3\2\2\2\5\23\33\"";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}