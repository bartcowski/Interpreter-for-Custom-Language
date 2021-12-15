package parser;

import lexer.Lexer;
import lexer.Token;
import parser.tree.node.Program;

public class Parser {

    private final Lexer lexer;

    private Token token;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
    }

    public Program parseProgram() {
        Program program = new Program();

        token = lexer.createNextToken();


        return program;
    }
}
