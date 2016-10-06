grammar Micro;

// Lexical Grammar

Begin   : 'begin';
End     : 'end';
Read    : 'read';
Write   : 'write';

Constant  : Digit+;
Identifier  : Letter+ Digit*;

Letter : 'a'..'z' | 'A'..'Z';
Digit : '0'..'9';

Operator : AddOpetator | SubOperator;

AddOpetator : '+';
SubOperator : '-';

Comma : ',';
RightParen : ')';
LeftParen : '(';

Assign : ':=';

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

readOperation : Read LeftParen listOfIdentifier RightParen Semicolon;
assignOperation : Identifier Assign expression Semicolon;
writeOperation : Write LeftParen listOfExpression RightParen Semicolon;

sentence :  readOperation | assignOperation | writeOperation;

program : Begin sentence* End EOF;