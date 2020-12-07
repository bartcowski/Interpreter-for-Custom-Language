import input.SourceCodeFileHandler;
import org.junit.jupiter.api.Test;
import util.Constants;

import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO doesn't work - for some reason file path/name string is only acceptable when given as a console argument
// TODO also: creating test resources directory breaks resource files searching outside tests
public class SourceCodeFileHandlerTest {
    @Test
    public void shouldReadOneProperCharacter() {
        SourceCodeFileHandler fileHandler = new SourceCodeFileHandler("test1.dpl");
        fileHandler.readNextChar();

        assertEquals('t', fileHandler.getCurrentChar());
    }

    @Test
    public void shouldReadWholeLine() {
        SourceCodeFileHandler fileHandler = new SourceCodeFileHandler("test1.dpl");
        StringBuilder builder = new StringBuilder();

        while (fileHandler.getCurrentChar() != Constants.ETX) {
            fileHandler.readNextChar();
            builder.append(fileHandler.getCurrentChar());
        }

        String result = builder.toString();
        assertEquals("testing file handler", result);
    }
}
