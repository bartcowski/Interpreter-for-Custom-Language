package lexer;

import input.SourceCodeFileHandler;
import util.*;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lexer {
    private SourceCodeFileHandler source;
    private Map<String, TokenType> simpleTokens;
    private Map<String, TokenType> keyWordsTokens;

    public Lexer(SourceCodeFileHandler source) {
        this.source = source;
        initializeSimpleTokens();
        initializeKeyWordsTokens();
    }

    public Token createNextToken() {
        skipWhitespaces();
        PositionInFile currentTokenPosition = new PositionInFile(source.getCurrentPosition().line,
                                                                 source.getCurrentPosition().column);
        Character c = source.getCurrentChar();

        if (Character.isLetter(c)) {
            return createIdentifierToken(currentTokenPosition);
        } else if (Character.isDigit(c)) {
            return createNumberToken(currentTokenPosition);
        } else if (c == '"') {
            return createStringLiteralToken(currentTokenPosition);
        } else if (simpleTokens.containsKey(c.toString() + source.readAndGetNextChar().toString())) {
            String cc = c.toString() + source.getCurrentChar();
            source.readNextChar();
            return new Token(cc, simpleTokens.get(cc), new PositionInFile(currentTokenPosition));
        } else if (simpleTokens.containsKey(c.toString())) {
            return new Token(c.toString(), simpleTokens.get(c.toString()), new PositionInFile(currentTokenPosition));
        } else if (c == Constants.ETX) {
            return new Token("ETX", TokenType.ETX, new PositionInFile(currentTokenPosition));
        } else {
            throw new InvalidTokenException("Lexer encountered an invalid token at " +
                                            "(line: " + currentTokenPosition.line + ", " +
                                            "column: " + currentTokenPosition.column + ")");
        }
    }

    private Token createIdentifierToken(PositionInFile position) {
        final int MAX_SIZE = 100;
        StringBuilder builder = new StringBuilder();

        while (Character.isJavaIdentifierPart(source.getCurrentChar())) {
            if (builder.length() >= MAX_SIZE) {
                throw new IdentifierTooLongException("There is a too long identifier name at: " +
                                                     "(line: " + position.line + ", " +
                                                     "column: " + position.column + ")");
            }
            builder.append(source.getCurrentChar());
            source.readNextChar();

            if (keyWordsTokens.containsKey(builder.toString())) {
                return new Token(builder.toString(), keyWordsTokens.get(builder.toString()), new PositionInFile(position));
            }
        }

        return new Token(builder.toString(), TokenType.ID, new PositionInFile(position));
    }

    private Token createNumberToken(PositionInFile position) {
        String number = "";

        number = checkBeforeDotFound();
        if (source.getCurrentChar() == '.') {
            number = checkAfterDotFound(number);
        } else {
            Integer.parseInt(number);
            return new Token(number, TokenType.INTEGER, new PositionInFile(position));
        }

        return new Token(number, TokenType.DOUBLE, new PositionInFile(position));
    }

    private String checkBeforeDotFound() {
        StringBuilder builder = new StringBuilder();

        if (source.getCurrentChar() == '0') {
            builder.append(source.getCurrentChar());
            source.readNextChar();
            return builder.toString();
        }

        while (Character.isDigit(source.getCurrentChar())) {
            builder.append(source.getCurrentChar());
            Double.parseDouble(builder.toString());
            source.readNextChar();
        }

        return builder.toString();
    }

    private String checkAfterDotFound(String number) {
        StringBuilder builder = new StringBuilder(number);
        builder.append(source.getCurrentChar());
        source.readNextChar();

        while (Character.isDigit(source.getCurrentChar())) {
            builder.append(source.getCurrentChar());
            Double.parseDouble(builder.toString());
            source.readNextChar();
        }

        return builder.toString();
    }

    private Token createStringLiteralToken(PositionInFile position) {
        final int MAX_SIZE = 1000;
        StringBuilder builder = new StringBuilder();

        source.readNextChar();
        while (source.getCurrentChar() != Constants.ETX && source.getCurrentChar() != '\"') {
            if (builder.length() >= MAX_SIZE) {
                throw new StringLiteralTooLongException("There is a string literal that exceeds maximum length");
            }

            builder.append(source.getCurrentChar());
            source.readNextChar();
        }

        source.readNextChar(); //skip string closing '"' character
        return new Token(builder.toString(), TokenType.STRING_LITERAL, new PositionInFile(position));
    }

    private void skipWhitespaces() {
        while (Character.isWhitespace(source.getCurrentChar())) {
            source.readNextChar();
        }
    }

    private void initializeSimpleTokens() {
        simpleTokens = Stream.of(new Object[][] {
                { "=", TokenType.ASSIGN },
                { "==", TokenType.EQUALS },
                { "!=", TokenType.NOT_EQUALS },
                { "<", TokenType.LESS },
                { ">", TokenType.GREATER },
                { "<=", TokenType.LESS_EQUALS },
                { ">=", TokenType.GREATER_EQUALS },
                { "&", TokenType.AND },
                { "|", TokenType.OR },
                { "+", TokenType.PLUS },
                { "-", TokenType.MINUS },
                { "*", TokenType.MULT },
                { "/", TokenType.DIV },
                { "(", TokenType.L_BRACKET },
                { ")", TokenType.R_BRACKET },
                { "{", TokenType.L_CURLYBRACKET },
                { "}", TokenType.R_CURLYBRACKET },
                { ";", TokenType.SEMICOL },
                { ".", TokenType.DOT },
                { ",", TokenType.COMMA },
                { "]", TokenType.L_TYPEBRACKET },
                { "[", TokenType.R_TYPEBRACKET }
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (TokenType) data[1]));
    }

    private void initializeKeyWordsTokens() {
        keyWordsTokens = Stream.of(new Object[][] {
                { "struct", TokenType.STRUCT },
                { "if", TokenType.IF },
                { "elif", TokenType.ELIF },
                { "else", TokenType.ELSE },
                { "return", TokenType.RETURN },
                { "void", TokenType.VOID },
                { "int", TokenType.VAR_TYPE },
                { "double", TokenType.VAR_TYPE },
                { "string", TokenType.VAR_TYPE },
                { "List", TokenType.VAR_TYPE },
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (TokenType) data[1]));
    }
}