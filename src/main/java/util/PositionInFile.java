package util;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString(includeFieldNames = true)
public class PositionInFile {
    public int line;
    public int column;

    public PositionInFile(PositionInFile position) {
        this.line = position.line;
        this.column = position.column;
    }
}
