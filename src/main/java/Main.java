import input.SourceCodeFileHandler;
import lexer.Lexer;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("You need to provide ONE source code file");
        } else {
            SourceCodeFileHandler sourceCodeFileHandler = new SourceCodeFileHandler(args[0]);
            Lexer lexer = new Lexer(sourceCodeFileHandler);
            lexer.createToken();
        }
    }
}
