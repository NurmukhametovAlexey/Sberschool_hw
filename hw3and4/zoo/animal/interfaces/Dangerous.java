package ru.sbrf.lesson3.hw3and4.zoo.animal.interfaces;

import ru.sbrf.lesson3.hw3and4.zoo.exception.VisitorHurtException;

public interface Dangerous {
    void attack() throws VisitorHurtException;
}