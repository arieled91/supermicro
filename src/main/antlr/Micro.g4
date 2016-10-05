grammar Micro;

// Lexical Grammar

Begin   : 'begin' (WhiteSpace|NewLine)*;
End     : 'end';
Read    : 'read';
Write   : 'write';

Constant  : Digit+;
Identifier  : Letter+ Digit*;

Letter : 'a'..'z' | 'A'..'Z';
Digit : '0'..'9';

Operator : AddOp | SubOp;

AddOp : '+';
SubOp : '-';

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

expression : primary (Operator primary)*;

listOfIdentifier : Identifier (Comma Identifier)*;
listOfExpression : expression (Comma expression)*;

readOp : Read LeftParen listOfIdentifier RightParen Semicolon;
assignOp : Identifier Assign expression Semicolon;
writeOp : Write LeftParen listOfExpression RightParen Semicolon;

sentence :  readOp* assignOp* writeOp*;

program : Begin sentence End EOF;