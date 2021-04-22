package ru.sbrf.lesson3.hw3and4.zoo.exception;

public class ZooFullException extends RuntimeException {
    public ZooFullException() {
        super();
    }

    public ZooFullException(String message) {
        super(message);
    }
}
