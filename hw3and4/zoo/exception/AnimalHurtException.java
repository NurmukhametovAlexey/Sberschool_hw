package ru.sbrf.lesson3.hw3and4.zoo.exception;

public class AnimalHurtException extends RuntimeException {
    public AnimalHurtException(String message) {
        super(message);
    }
    public AnimalHurtException() {
        super();
    }

}
