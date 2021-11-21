package lexer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import util.PositionInFile;

@AllArgsConstructor
@ToString()
@Getter
public class Token {
    private final String lexeme;
    private final TokenType type;
    private final PositionInFile position;
}
