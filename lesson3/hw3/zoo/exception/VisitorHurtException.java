package ru.sbrf.lesson3.hw3.zoo.exception;

public class VisitorHurtException extends RuntimeException{
    public VisitorHurtException(String message) {
        super(message);
    }
    public VisitorHurtException(){
        super();
    }
}
