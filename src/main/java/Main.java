import input.SourceCodeFileHandler;
import input.SourceCodeSource;
import lexer.Lexer;
import lexer.Token;
import lexer.TokenType;
import parser.Parser;
import parser.tree.node.Program;
import util.Constants;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("You need to provide ONE source code file");
        } else {
            SourceCodeSource sourceCodeFileHandler = new SourceCodeFileHandler(args[0]);
            Lexer lexer = new Lexer(sourceCodeFileHandler);

            Token token;
            while (sourceCodeFileHandler.getCurrentChar() != Constants.ETX) {
                token = lexer.createNextToken();
                System.out.println(token.toString());
            }

            Parser parser = new Parser(lexer);
            Program program = parser.parseProgram();
            System.out.println(program.toString());

        }
    }
}
