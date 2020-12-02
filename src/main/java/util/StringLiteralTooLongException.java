package util;

public class StringLiteralTooLongException extends RuntimeException {
    public StringLiteralTooLongException(String errorMessage) {
        super(errorMessage);
    }
}
