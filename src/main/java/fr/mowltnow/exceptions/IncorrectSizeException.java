package fr.mowltnow.exceptions;

public class IncorrectSizeException extends RuntimeException {

    public IncorrectSizeException() {
        super("Incorrect size of the lawn");
    }
}
