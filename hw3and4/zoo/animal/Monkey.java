package ru.sbrf.lesson3.hw3and4.zoo.animal;

import ru.sbrf.lesson3.hw3and4.zoo.exception.VisitorOffendedException;

import java.util.concurrent.ThreadLocalRandom;

public class Monkey extends Animal implements Walkable, Vegetarian{
    public Monkey(String name, int age) {
        super(name, age);
    }

    @Override
    public void say() {
        System.out.println("Chatter!");
    }

    @Override
    public void feed() {
        System.out.println("Feeding monkey with fruits");
    }

    @Override
    public void feed(String treats) {
        System.out.println("Feeding monkey with " + treats);
    }

    @Override
    public void walk() {
        System.out.println("Monkey walks and jumps on the trees");
    }

    @Override
    public void eatFromVisitor() {
        System.out.println("Visitor feeds the Monkey...");
        double outcome = ThreadLocalRandom.current().nextDouble(1);
        if (outcome > 0.5) {
            System.out.println("Nothing bad happens");
        }
        else {
            System.out.println("Monkey threw the food back!");
            throw new VisitorOffendedException("Monkey threw the food back!");
        }
    }
}
