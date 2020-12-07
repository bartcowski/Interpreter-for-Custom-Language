package input;

import util.PositionInFile;

public interface SourceCodeSource {
    PositionInFile getCurrentPosition();
    Character getCurrentChar();
    void readNextChar();
    Character readAndGetNextChar();
}
