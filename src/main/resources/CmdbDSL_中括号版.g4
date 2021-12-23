grammar CmdbDSL;
@header{
    package codedriver.framework.cmdb.dsl;
}

expressions : ciAttrs comparisonOperator (STRING|NUMBER|NUMBER_ARRAY|STRING_ARRAY) #expression
           | expressions logicalOperator expressions #expressionJoin
           | '(' expressions ')' #expressionGroup;

attrs : ATTR* ANY_ATTR? ATTR+;
ciAttrs : CI attrs+;

logicalOperator : '&&'|'||';

comparisonOperator
    : '=='
    | '>'
    | '<'
    | '<='
    | '>='
    | '!='
    | 'like'
    | 'include'
    | 'exclude'
    ;

CI : '$'[a-zA-Z_][a-zA-Z_0-9]*;
ATTR : '['[a-zA-Z_][a-zA-Z_0-9]*']';
ANY_ATTR : '[*]';
STRING : '"'(~[\\"])*?'"';
NUMBER_ARRAY : '[' (NUMBER ',')* NUMBER ']';
STRING_ARRAY : '[' (STRING ',')* STRING ']';
NUMBER : ('-')?((([0]|[1-9]+[0-9]*)([.])[0-9]+|[1-9][0-9]*));
//抛弃没用的空格和换行识别
WHITESPACE : ( '\t' | ' ' | '\r' | '\n' )+ -> channel(HIDDEN);


