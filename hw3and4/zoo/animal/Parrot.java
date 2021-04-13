package ru.sbrf.lesson3.hw3and4.zoo.animal;

import ru.sbrf.lesson3.hw3and4.zoo.exception.VisitorHurtException;

import java.util.concurrent.ThreadLocalRandom;

public class Parrot extends Animal implements Flyable, Vegetarian{
    public Parrot(String name, int age) {
        super(name, age);
    }

    @Override
    public void say() {
        System.out.println("Squawk!");
    }

    @Override
    public void feed() {
        System.out.println("Feeding parrot with grain");
    }

    @Override
    public void feed(String treats) {
        System.out.println("Feeding parrot with " + treats);
    }

    @Override
    public void fly() {
        System.out.println("The parrot flies");
    }

    @Override
    public void land() {
        System.out.println("The parrot landed on the perch");
    }

    @Override
    public void eatFromVisitor() {
        System.out.println("Visitor feeds the parrot...");
        double outcome = ThreadLocalRandom.current().nextDouble(1);
        if (outcome > 0.5) {
            System.out.println("Nothing bad happens");
        }
        else {
            System.out.println("Parrot beaked the visitor!");
            throw new VisitorHurtException("Parrot beaked the visitor!");
        }
    }
}
