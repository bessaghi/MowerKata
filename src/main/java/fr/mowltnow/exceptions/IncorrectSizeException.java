package fr.mowltnow.exceptions;

public class IncorrectSizeException extends RuntimeException {

    public IncorrectSizeException(String message) {
        super(message);
    }

    public IncorrectSizeException(String message, RuntimeException exception) {
        super(message, exception);
    }
}
