grammar CmdbDSL;
@header{
    package codedriver.framework.cmdb.dsl;
}



//calculateExpressions : BRACKET_LEFT (calculateExpressions|attrs|NUMBER) (calculateOperator (calculateExpressions|attrs|NUMBER))* BRACKET_RIGHT;
calculateExpressions : calculateExpressions op=('*'|'/') calculateExpressions
                     | calculateExpressions op=('+'|'-') calculateExpressions
                     | attrs|NUMBER
                     | '(' calculateExpressions ')';

expressions : attrs comparisonOperator (STRING|NUMBER|NUMBER_ARRAY|STRING_ARRAY|calculateExpressions) #expression
           | expressions logicalOperator expressions #expressionJoin
           | BRACKET_LEFT expressions BRACKET_RIGHT #expressionGroup;

attrs : (ATTR '.')* ATTR;
//ciAttrs : CI attrs+;

logicalOperator : '&&'
                | '||';

comparisonOperator
    : '=='
    | '>'
    | '<'
    | '<='
    | '>='
    | '!='
    | 'include'
    | 'exclude'
    ;

calculateOperator : PLUS
                  | SUBTRACT
                  | MULTIPLY
                  | DIVIDE;

NUMBER_ARRAY : '[' (NUMBER ',')* NUMBER ']';
STRING_ARRAY : '[' (STRING ',')* STRING ']';
NUMBER : '-'?([0]|[1-9][0-9]*|'0.'[0-9]+|[1-9][0-9]*'.'[0-9]+);
BRACKET_LEFT : '(';
BRACKET_RIGHT : ')';
AND : '&&';
OR : '||';
EQ : '==';
GT : '>';
LT : '<';
LE : '<=';
GE : '>=';
PLUS : '+';
SUBTRACT : '-';
MULTIPLY : '*';
DIVIDE : '/';
NOTEQ : '!=';
LIKE : 'like';
INCLUDE : 'include';
EXCLUDE : 'exclude';

ATTR : [a-zA-Z_][a-zA-Z_0-9]*;
STRING : '"'(~[\\"])*?'"';
//抛弃没用的空格和换行识别
WHITESPACE : ( '\t' | ' ' | '\r' | '\n' )+ -> channel(HIDDEN);


