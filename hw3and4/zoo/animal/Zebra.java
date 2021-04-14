package ru.sbrf.lesson3.hw3and4.zoo.animal;

import ru.sbrf.lesson3.hw3and4.zoo.animal.interfaces.Vegetarian;
import ru.sbrf.lesson3.hw3and4.zoo.animal.interfaces.Walkable;
import ru.sbrf.lesson3.hw3and4.zoo.exception.VisitorHurtException;

import java.util.concurrent.ThreadLocalRandom;

public class Zebra extends Animal implements Walkable, Vegetarian {

    public Zebra(String name, int age) {
        super(name, age);
    }

    @Override
    public void say() {
        System.out.println("Neigh!");
    }

    @Override
    public void feed() {
        System.out.println("Feeding zebra with straw");
    }

    @Override
    public void feed(String treats) {
        System.out.println("Feeding zebra with " + treats);
    }

    @Override
    public void walk() {
        System.out.println("Zebra prances");
    }

    @Override
    public void eatFromVisitor() {
        System.out.println("Visitor feeds the zebra...");
        double outcome = ThreadLocalRandom.current().nextDouble(1);
        if (outcome > 0.5) {
            System.out.println("Nothing bad happens");
        }
        else {
            System.out.println("Zebra trampled the visitor!");
            throw new VisitorHurtException("Zebra trampled the visitor!");
        }
    }
}
