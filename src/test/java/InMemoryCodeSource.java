import input.SourceCodeSource;
import util.PositionInFile;

public class InMemoryCodeSource implements SourceCodeSource {
    private PositionInFile currentPosition = new PositionInFile(1, 0);
    private char currentChar;
    private char[] chars;

    public InMemoryCodeSource(char[] chars) {
        this.chars = chars;
        readNextChar();
    }

    @Override
    public Character getCurrentChar() {
        return currentChar;
    }

    @Override
    public PositionInFile getCurrentPosition() {
        return currentPosition;
    }

    @Override
    public void readNextChar() {
        currentChar = chars[currentPosition.column];
        currentPosition.column++;
    }

    @Override
    public Character readAndGetNextChar() {
        currentChar = chars[currentPosition.column];
        currentPosition.column++;
        return getCurrentChar();
    }
}
