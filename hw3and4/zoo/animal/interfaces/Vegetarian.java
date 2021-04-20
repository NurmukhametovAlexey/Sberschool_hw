package ru.sbrf.lesson3.hw3and4.zoo.animal.interfaces;

import ru.sbrf.lesson3.hw3and4.zoo.exception.AnimalHurtException;
import ru.sbrf.lesson3.hw3and4.zoo.exception.VisitorHurtException;
import ru.sbrf.lesson3.hw3and4.zoo.exception.VisitorOffendedException;

public interface Vegetarian {
    void eatFromVisitor() throws VisitorHurtException, VisitorOffendedException, AnimalHurtException;
}