/*
 Based on: http://json.org/ https://andreabergia.com/a-grammar-for-json-with-antlr-v4/
 https://github.com/antlr/grammars-v4/blob/master/json/JSON.g4
 */

grammar Json;

json: array | object;
array: '[' ']' | '[' value (',' value)* ']';
object: '{' '}' | '{' pair (',' pair)* '}';
value: array | BOOLEAN | NULL | NUMBER | object | STRING;
pair: STRING ':' value;

BOOLEAN: 'true' | 'false';

NULL: 'null';

NUMBER: SIGN? INT ('.' FRAC)? EXP?;
fragment SIGN: '-';
fragment INT: '0' | [1-9][0-9]*;
fragment FRAC: [0-9]+;
fragment EXP: [Ee] [+\-]? INT;

STRING: '"' ( ESC | SAFECODEPOINT)* '"';
fragment ESC: '\\' (["\\/bfnrt] | UNICODE);
fragment UNICODE: 'u' HEX HEX HEX HEX;
fragment HEX: [0-9a-fA-F];
fragment SAFECODEPOINT: ~["\\];

WS: [ \t\n\r]+ -> skip;
