package lexer;

import util.PositionInFile;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Token {
    private String lexeme;
    private TokenType type;
    private PositionInFile position;
}
