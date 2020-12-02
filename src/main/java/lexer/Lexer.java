package lexer;

import input.SourceCodeFileHandler;
import util.*;

public class Lexer {
    private SourceCodeFileHandler source;

    public Lexer(SourceCodeFileHandler source) {
        this.source = source;
    }

    public void createToken() {
        StringBuilder code = new StringBuilder();
        int count = 0;
        while (source.getCurrentChar() != Constants.ETX) {
            System.out.println(count++ + " " + source.getCurrentChar());

            skipWhitespaces();
            code.append(source.getCurrentChar());
            source.readNextChar();
        }

        System.out.println(code);
    }

    private void skipWhitespaces() {
        while (Character.isWhitespace(source.getCurrentChar())) {
            source.readNextChar();
        }
    }
}
