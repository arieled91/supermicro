grammar Micro;

// Lexical Grammar

Begin   : 'begin';
End     : 'end';
Read    : 'read';
Write   : 'write';

If : 'if';
Else : 'else';



Constant  : ('0x' | '0b') ? Digit+ ('.' Digit+)?;
Identifier  : Letter+ Digit*;

Letter : 'a'..'z' | 'A'..'Z';
Digit : '0'..'9';


Comma : ',';
RightParen : ')';
LeftParen : '(';

Assign : ':=';



Compare : (Equals | NotEquals | Grater | GraterEquals | Lower | LowerEquals);

Equals : '=';
NotEquals : '!=';
Grater : '>';
GraterEquals : '>=';
Lower : '<';
LowerEquals : '<=';

LogicalOperator : And | Or;

And : '&';
Or  : '|';

Operator : DivOperator | ProdOperator | AddOpetator | SubOperator;

AddOpetator  : '+';
SubOperator  : '-';
ProdOperator : '*';
DivOperator  : '/';


Semicolon : ';';

WhiteSpace : [' '|'\t'] -> skip;
NewLine : ['\r''\n'|'\r'|'\n'] -> skip;
Comment : '//' ~['\r''\n'|'\r'|'\n']* -> skip;


// Syntactic Grammar

primary : Identifier | Constant | LeftParen expression RightParen;
rightPrimary : Operator primary;
expression : primary rightPrimary*;

listOfIdentifier : Identifier (Comma Identifier)*;
listOfExpression : expression (Comma expression)*;

readStatement : Read LeftParen listOfIdentifier RightParen Semicolon;
assignStatement : Identifier Assign expression  Semicolon;
writeStatement : Write LeftParen listOfExpression RightParen  Semicolon;

comparison : expression Compare expression;
rightComparison : LogicalOperator comparison;
elseSentences : Else statement*;

ifStatement : If LeftParen comparison rightComparison* RightParen statement* (elseSentences)? End;

statement :  (readStatement | assignStatement | writeStatement | ifStatement);

program : Begin statement* End EOF;