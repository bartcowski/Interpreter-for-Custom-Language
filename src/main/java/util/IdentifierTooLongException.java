package util;

public class IdentifierTooLongException extends RuntimeException {
    public IdentifierTooLongException(String errorMessage) {
        super(errorMessage);
    }
}
