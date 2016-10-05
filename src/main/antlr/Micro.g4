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

program : Begin sentenceList End;

sentenceList : sentence;

sentence :  Identifier Assign expression Semicolon |
            Read RightParen identifierList LeftParen |
            Write RightParen expessionList LeftParen;

identifierList : Identifier (Comma Identifier)*;
expessionList : expression (Comma expression)*;

expression : primary (Operator primary)*;
primary : Identifier | Constant | RightParen expression LeftParen;