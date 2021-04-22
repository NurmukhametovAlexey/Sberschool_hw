package ru.sbrf.lesson3.hw3and4.zoo.exception;

public class AnimalDuplicateException extends RuntimeException{
    public AnimalDuplicateException() {
        super();
    }

    public AnimalDuplicateException(String message) {
        super(message);
    }
}
