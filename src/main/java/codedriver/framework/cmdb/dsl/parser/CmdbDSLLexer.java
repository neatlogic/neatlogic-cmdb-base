/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

// Generated from /Users/chenqiwei/idea_project/codedriver/codedriver-cmdb-base/src/main/resources/CmdbDSL.g4 by ANTLR 4.9.2

package codedriver.framework.cmdb.dsl.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmdbDSLLexer extends Lexer {
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
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };

    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    private static String[] makeRuleNames() {
        return new String[]{
                "T__0", "NUMBER_ARRAY", "STRING_ARRAY", "NUMBER", "BRACKET_LEFT", "BRACKET_RIGHT",
                "AND", "OR", "EQ", "GT", "LT", "LE", "GE", "NOTEQ", "INCLUDE", "EXCLUDE",
                "ATTR", "STRING", "WHITESPACE"
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


    public CmdbDSLLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
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
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u00a6\b\1\4\2" +
                    "\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4" +
                    "\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22" +
                    "\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\3\3\3\3\7\3\60\n\3\f\3\16\3" +
                    "\63\13\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4<\n\4\f\4\16\4?\13\4\3\4\3\4\3" +
                    "\4\3\5\5\5E\n\5\3\5\3\5\3\5\7\5J\n\5\f\5\16\5M\13\5\3\5\3\5\3\5\3\5\6" +
                    "\5S\n\5\r\5\16\5T\3\5\3\5\7\5Y\n\5\f\5\16\5\\\13\5\3\5\3\5\6\5`\n\5\r" +
                    "\5\16\5a\5\5d\n\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n" +
                    "\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20" +
                    "\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21" +
                    "\3\22\3\22\7\22\u0092\n\22\f\22\16\22\u0095\13\22\3\23\3\23\7\23\u0099" +
                    "\n\23\f\23\16\23\u009c\13\23\3\23\3\23\3\24\6\24\u00a1\n\24\r\24\16\24" +
                    "\u00a2\3\24\3\24\3\u009a\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13" +
                    "\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25\3\2\t\3\2\62\62\3" +
                    "\2\63;\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\4\2$$^^\5\2\13\f\17\17\"\"\2" +
                    "\u00b2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2" +
                    "\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3" +
                    "\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2" +
                    "\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5+\3\2\2\2\7\67\3\2\2\2" +
                    "\tD\3\2\2\2\13e\3\2\2\2\rg\3\2\2\2\17i\3\2\2\2\21l\3\2\2\2\23o\3\2\2\2" +
                    "\25r\3\2\2\2\27t\3\2\2\2\31v\3\2\2\2\33y\3\2\2\2\35|\3\2\2\2\37\177\3" +
                    "\2\2\2!\u0087\3\2\2\2#\u008f\3\2\2\2%\u0096\3\2\2\2\'\u00a0\3\2\2\2)*" +
                    "\7\60\2\2*\4\3\2\2\2+\61\7]\2\2,-\5\t\5\2-.\7.\2\2.\60\3\2\2\2/,\3\2\2" +
                    "\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2\2\63\61\3\2\2\2" +
                    "\64\65\5\t\5\2\65\66\7_\2\2\66\6\3\2\2\2\67=\7]\2\289\5%\23\29:\7.\2\2" +
                    ":<\3\2\2\2;8\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>@\3\2\2\2?=\3\2\2\2" +
                    "@A\5%\23\2AB\7_\2\2B\b\3\2\2\2CE\7/\2\2DC\3\2\2\2DE\3\2\2\2Ec\3\2\2\2" +
                    "Fd\t\2\2\2GK\t\3\2\2HJ\t\4\2\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2" +
                    "Ld\3\2\2\2MK\3\2\2\2NO\7\62\2\2OP\7\60\2\2PR\3\2\2\2QS\t\4\2\2RQ\3\2\2" +
                    "\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2Ud\3\2\2\2VZ\t\3\2\2WY\t\4\2\2XW\3\2\2" +
                    "\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2\2\\Z\3\2\2\2]_\7\60\2\2^`\t" +
                    "\4\2\2_^\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2\2bd\3\2\2\2cF\3\2\2\2cG\3" +
                    "\2\2\2cN\3\2\2\2cV\3\2\2\2d\n\3\2\2\2ef\7*\2\2f\f\3\2\2\2gh\7+\2\2h\16" +
                    "\3\2\2\2ij\7(\2\2jk\7(\2\2k\20\3\2\2\2lm\7~\2\2mn\7~\2\2n\22\3\2\2\2o" +
                    "p\7?\2\2pq\7?\2\2q\24\3\2\2\2rs\7@\2\2s\26\3\2\2\2tu\7>\2\2u\30\3\2\2" +
                    "\2vw\7>\2\2wx\7?\2\2x\32\3\2\2\2yz\7@\2\2z{\7?\2\2{\34\3\2\2\2|}\7#\2" +
                    "\2}~\7?\2\2~\36\3\2\2\2\177\u0080\7k\2\2\u0080\u0081\7p\2\2\u0081\u0082" +
                    "\7e\2\2\u0082\u0083\7n\2\2\u0083\u0084\7w\2\2\u0084\u0085\7f\2\2\u0085" +
                    "\u0086\7g\2\2\u0086 \3\2\2\2\u0087\u0088\7g\2\2\u0088\u0089\7z\2\2\u0089" +
                    "\u008a\7e\2\2\u008a\u008b\7n\2\2\u008b\u008c\7w\2\2\u008c\u008d\7f\2\2" +
                    "\u008d\u008e\7g\2\2\u008e\"\3\2\2\2\u008f\u0093\t\5\2\2\u0090\u0092\t" +
                    "\6\2\2\u0091\u0090\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093" +
                    "\u0094\3\2\2\2\u0094$\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u009a\7$\2\2\u0097" +
                    "\u0099\n\7\2\2\u0098\u0097\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u009b\3\2" +
                    "\2\2\u009a\u0098\3\2\2\2\u009b\u009d\3\2\2\2\u009c\u009a\3\2\2\2\u009d" +
                    "\u009e\7$\2\2\u009e&\3\2\2\2\u009f\u00a1\t\b\2\2\u00a0\u009f\3\2\2\2\u00a1" +
                    "\u00a2\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2" +
                    "\2\2\u00a4\u00a5\b\24\2\2\u00a5(\3\2\2\2\16\2\61=DKTZac\u0093\u009a\u00a2" +
                    "\3\2\3\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}