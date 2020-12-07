import lexer.Lexer;
import lexer.Token;
import lexer.TokenType;
import org.junit.jupiter.api.Test;
import util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LexerTest {
    InMemoryCodeSource source;

    @Test
    public void shouldCreateIdTokenOfProperLexemeName() {
        char[] chars = {'t','o','k','e','n',' '};

        source = new InMemoryCodeSource(chars);
        Lexer lexer = new Lexer(source);
        Token token = lexer.createNextToken();

        assertEquals("token", token.getLexeme());
        assertEquals(TokenType.ID, token.getType());
    }

    @Test
    public void shouldCreateIdKeywordTokenOfProperLexemeName() {
        char[] chars = {'r','e','t','u','r','n',' '};

        source = new InMemoryCodeSource(chars);
        Lexer lexer = new Lexer(source);
        Token token = lexer.createNextToken();

        assertEquals("return", token.getLexeme());
        assertEquals(TokenType.RETURN, token.getType());
    }

    @Test
    public void shouldCreateIntegerTokenOfProperLexemeName() {
        char[] chars = {'1','2','3','4',' '};

        source = new InMemoryCodeSource(chars);
        Lexer lexer = new Lexer(source);
        Token token = lexer.createNextToken();

        assertEquals("1234", token.getLexeme());
        assertEquals(TokenType.INTEGER, token.getType());
    }

    @Test
    public void shouldCreateDoubleTokenOfProperLexemeName() {
        char[] chars = {'0','.','9','9',' '};

        source = new InMemoryCodeSource(chars);
        Lexer lexer = new Lexer(source);
        Token token = lexer.createNextToken();

        assertEquals("0.99", token.getLexeme());
        assertEquals(TokenType.DOUBLE, token.getType());
    }

    @Test
    public void shouldCreateStringLiteralTokenOfProperLexemeName() {
        char[] chars = {'\"','h','e','l','l','o','\"',' '};

        source = new InMemoryCodeSource(chars);
        Lexer lexer = new Lexer(source);
        Token token = lexer.createNextToken();

        assertEquals("hello", token.getLexeme());
        assertEquals(TokenType.STRING_LITERAL, token.getType());
    }

    @Test
    public void shouldCreateTwoCharSimpleTokenOfProperLexemeName() {
        char[] chars = {'>','=',' '};

        source = new InMemoryCodeSource(chars);
        Lexer lexer = new Lexer(source);
        Token token = lexer.createNextToken();

        assertEquals(">=", token.getLexeme());
        assertEquals(TokenType.GREATER_EQUALS, token.getType());
    }

    @Test
    public void shouldCreateOneCharSimpleTokenOfProperLexemeName() {
        char[] chars = {'=',' '};

        source = new InMemoryCodeSource(chars);
        Lexer lexer = new Lexer(source);
        Token token = lexer.createNextToken();

        assertEquals("=", token.getLexeme());
        assertEquals(TokenType.ASSIGN, token.getType());
    }

    @Test
    public void shouldSkipSpacesAndCreateAssignSimpleToken() {
        char[] chars = {' ',' ',' ','=',' '};

        source = new InMemoryCodeSource(chars);
        Lexer lexer = new Lexer(source);
        Token token = lexer.createNextToken();

        assertEquals("=", token.getLexeme());
        assertEquals(TokenType.ASSIGN, token.getType());
    }

    @Test
    public void shouldThrowInvalidTokenExceptionForWrongInput() {
        char[] chars = {':','1','-','=',' '};

        source = new InMemoryCodeSource(chars);
        Lexer lexer = new Lexer(source);

        assertThrows(InvalidTokenException.class, lexer::createNextToken);
    }

    @Test
    public void shouldThrowIdentifierTooLongException() {
        char[] chars = {'a','a','a','a','a','a','a','a','a','a',
                        'a','a','a','a','a','a','a','a','a','a',
                        'a','a','a','a','a','a','a','a','a','a',
                        'a','a','a','a','a','a','a','a','a','a',
                        'a','a','a','a','a','a','a','a','a','a',
                        'a','a','a','a','a','a','a','a','a','a',
                        'a','a','a','a','a','a','a','a','a','a',
                        'a','a','a','a','a','a','a','a','a','a',
                        'a','a','a','a','a','a','a','a','a','a',
                        'a','a','a','a','a','a','a','a','a','a',
                        'a','a','a','a','a','a','a','a','a',' '};

        source = new InMemoryCodeSource(chars);
        Lexer lexer = new Lexer(source);

        assertThrows(IdentifierTooLongException.class, lexer::createNextToken);
    }

    @Test
    public void shouldThrowStringLiteralTooLongException() {
        char[] chars = new char[1012];
        int i = 0;

        chars[i++] = '\"';
        for (; i < 1010; ++i) {
            chars[i] = 'a';
        }
        chars[i++] = '\"';
        chars[i] = ' ';

        source = new InMemoryCodeSource(chars);
        Lexer lexer = new Lexer(source);

        assertThrows(StringLiteralTooLongException.class, lexer::createNextToken);
    }
}
