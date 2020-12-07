package input;

import util.Constants;
import util.PositionInFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SourceCodeFileHandler implements SourceCodeSource {
    private FileReader reader;
    private PositionInFile currentPosition = new PositionInFile(1, 0);
    private int currentChar;

    public SourceCodeFileHandler(String path) {
        try {
            reader = new FileReader(path);
            readNextChar();
        } catch (FileNotFoundException e) {
            System.out.println("Source code file not found with given path: " + path);
            e.printStackTrace();
        }
    }

    public PositionInFile getCurrentPosition() {
        return currentPosition;
    }

    public Character getCurrentChar() {
        return (char) currentChar;
    }

    public void readNextChar() {
        try {
            assignNewCurrentCharAndUpdatePosition();
        } catch (IOException e) {
            System.out.println("Could not read the file");
            e.printStackTrace();
        }
    }

    public Character readAndGetNextChar() {
        readNextChar();
        return getCurrentChar();
    }

    private void assignNewCurrentCharAndUpdatePosition() throws IOException {
        currentChar = reader.read();

        if (currentChar != -1) {
            updateCurrentPosition();
        } else {
            currentChar = Constants.ETX;
        }
    }

    private void updateCurrentPosition() {
        if (currentChar == '\n') {
            currentPosition.line++;
            currentPosition.column = 0;
        } else {
            currentPosition.column++;
        }
    }
}
