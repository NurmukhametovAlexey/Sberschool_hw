package ru.sbrf.lesson3.hw3and4.zoo.animal;

import ru.sbrf.lesson3.hw3and4.zoo.exception.AnimalHurtException;
import ru.sbrf.lesson3.hw3and4.zoo.exception.VisitorHurtException;
import ru.sbrf.lesson3.hw3and4.zoo.exception.VisitorOffendedException;

public abstract class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        if (age > 0) {
            this.age = age;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public abstract void say();

    public abstract void feed();

    public abstract void feed(String treats);

    public void celebrateBDay(){
        System.out.println(name + " is " + (++age) + " now! Hurray!");
    }
}

interface Flyable {
    void fly();
    void land();
}

interface Swimmable {
    void swim();
}

interface Walkable {
    void walk();
}

interface Dangerous {
    void attack() throws VisitorHurtException;
}

interface Vegetarian {
    void eatFromVisitor() throws VisitorHurtException, VisitorOffendedException, AnimalHurtException;
}

