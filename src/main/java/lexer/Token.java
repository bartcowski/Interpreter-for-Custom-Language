package lexer;

import lombok.Getter;
import lombok.ToString;
import util.PositionInFile;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ToString(includeFieldNames = true)
@Getter
public class Token {
    private String lexeme;
    private TokenType type;
    private PositionInFile position;
}
