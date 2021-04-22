package ru.sbrf.lesson3.hw3and4.zoo.exception;

public class EnclosureFullException extends RuntimeException {
    public EnclosureFullException () {
        super();
    }
    public EnclosureFullException (String message) {
        super(message);
    }
}
