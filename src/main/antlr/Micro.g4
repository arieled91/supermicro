grammar Micro;

// Lexical Grammar

Begin   : 'begin';
End     : 'end';
Read    : 'read';
Write   : 'write';
Return  : 'return';

If : 'if';
Else : 'else';
While : 'while';



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


method : Identifier (LeftParen listOfIdentifier RightParen)? statement* returnStatement? End;

methodCall : Identifier LeftParen listOfExpression? RightParen;

primary : Identifier | methodCall | Constant | LeftParen expression RightParen;
rightPrimary : Operator primary;
expression : primary rightPrimary*;

listOfIdentifier : Identifier (Comma Identifier)*;
listOfExpression : expression (Comma expression)*;

readStatement : Read LeftParen listOfIdentifier RightParen Semicolon;
assignStatement : Identifier Assign expression  Semicolon;
writeStatement : Write LeftParen listOfExpression RightParen  Semicolon;
returnStatement : Return expression;

comparison : expression Compare expression;
rightComparison : LogicalOperator comparison;
elseSentences : Else statement* returnStatement?;

ifStatement : If LeftParen comparison rightComparison* RightParen statement* returnStatement? (elseSentences)? End;
whileStatement : While LeftParen comparison rightComparison* RightParen statement* End;


statement :  (readStatement | assignStatement | writeStatement | ifStatement| whileStatement);

program : Begin statement* returnStatement? End method* EOF;