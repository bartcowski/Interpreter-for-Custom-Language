package lexer;

public enum TokenType {
    IF,
    ELIF,
    ELSE,
    WHILE,
    RETURN,

    ID,
    INTEGER,
    DOUBLE,
    STRING_LITERAL,
    VAR_TYPE,
    VOID,

    ASSIGN,
    EQUALS,
    NOT_EQUALS,
    LESS,
    GREATER,
    LESS_EQUALS,
    GREATER_EQUALS,

    AND,
    OR,
    PLUS,
    MINUS,
    MULT,
    DIV,

    L_BRACKET,
    R_BRACKET,
    L_CURLYBRACKET,
    R_CURLYBRACKET,
    SEMICOL,
    DOT,
    COMMA,

    ETX
}
