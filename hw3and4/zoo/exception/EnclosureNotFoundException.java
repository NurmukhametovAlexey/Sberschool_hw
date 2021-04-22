package ru.sbrf.lesson3.hw3and4.zoo.exception;

public class EnclosureNotFoundException extends RuntimeException {
    public EnclosureNotFoundException() {
        super();
    }

    public EnclosureNotFoundException(String message) {
        super(message);
    }
}
