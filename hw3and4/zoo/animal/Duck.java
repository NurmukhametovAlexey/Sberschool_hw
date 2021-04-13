package ru.sbrf.lesson3.hw3and4.zoo.animal;

import ru.sbrf.lesson3.hw3and4.zoo.exception.AnimalHurtException;

import java.util.concurrent.ThreadLocalRandom;

public class Duck extends Animal implements Flyable, Walkable, Vegetarian {

    public Duck(String name, int age) {
        super(name, age);
    }

    @Override
    public void say() {
        System.out.println("Quack!");
    }

    @Override
    public void feed() {
        System.out.println("Feeding duck with grain");
    }

    @Override
    public void feed(String treats) {
        System.out.println("Feeding duck with " + treats);
    }

    @Override
    public void fly() {
        System.out.println("The duck flies but not particularly well");
    }

    @Override
    public void land() {
        System.out.println("The duck landed on the floor");
    }

    @Override
    public void walk() {
        System.out.println("The duck walks but not particularly well");
    }
    @Override
    public void eatFromVisitor() {
        System.out.println("Visitor feeds the duck...");
        double outcome = ThreadLocalRandom.current().nextDouble(1);
        if (outcome > 0.5) {
            System.out.println("Nothing bad happens");
        }
        else {
            System.out.println("Duck gets poisoned!");
            throw new AnimalHurtException("Duck gets poisoned!");
        }
    }

}
