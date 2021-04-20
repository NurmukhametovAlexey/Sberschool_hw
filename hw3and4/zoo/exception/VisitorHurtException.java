package ru.sbrf.lesson3.hw3and4.zoo.exception;

public class VisitorHurtException extends RuntimeException{
    public VisitorHurtException(String message) {
        super(message);
    }
    public VisitorHurtException(){
        super();
    }
}
