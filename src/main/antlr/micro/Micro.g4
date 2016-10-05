grammar Micro;

// Lexical Grammar

Letter : ('a'..'z') ('A'..'Z');
Digit : ('0'..'9');

Constant  : Digit+;
Identifier  : Letter+ Digit*;

AddOp : '+';
SubOp : '-';

Operator : AddOp | SubOp;

Comma : ',';
RightParen : '(';
LeftParen : ')';

Assign : ':=';

Semicolon : ';';

//reserved
Begin   : 'begin';
End     : 'end';
Read    : 'read';
Write   : 'write';

Ignore :   (' ' | '\t' | '\r'| '\n') -> skip ;

// Syntactic Grammar

program : Begin listOfSentence End;

listOfSentence : sentence;

sentence :  Identifier Assign expression Semicolon |
            Read RightParen listOfIdentifier LeftParen |
            Write RightParen listOfExpression LeftParen;

listOfIdentifier : Identifier (Comma Identifier)*;
listOfExpression : expression (Comma expression)*;

expression : primary (Operator primary)*;
primary : Identifier | Constant | RightParen expression LeftParen;