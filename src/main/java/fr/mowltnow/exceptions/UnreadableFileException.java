package fr.mowltnow.exceptions;

public class UnreadableFileException extends RuntimeException {

    public UnreadableFileException() {
        super("Could not read file");
    }
}
