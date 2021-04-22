package ru.sbrf.lesson3.hw3and4.zoo.exception;

public class VisitorOffendedException extends RuntimeException{
    public VisitorOffendedException(String message) {
        super(message);
    }
    public VisitorOffendedException() {
        super();
    }
}
