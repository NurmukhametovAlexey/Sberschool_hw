package ru.sbrf.lesson3.hw3.zoo.animal;

import java.util.concurrent.ThreadLocalRandom;

public class Wolf extends Animal implements Walkable, Dangerous{
    double dangerousness;

    public Wolf(String name, int age) {
        super(name, age);
        dangerousness = 0.25;
    }

    @Override
    public void say() {
        System.out.println("Howl!");
    }

    @Override
    public void feed() {
        System.out.println("Feeding wolf with entrails");
    }

    @Override
    public void feed(String treats) {
        System.out.println("Feeding wolf with " + treats);
    }

    @Override
    public void walk() {
        System.out.println("The wolf waddles");
    }

    @Override
    public void attack() {
        double outcome = ThreadLocalRandom.current().nextDouble(1);
        if (outcome < dangerousness) {
            System.out.println("Visitor came to close! Wolf scratched his hand!");
        }
        else {
            System.out.println("Visitor himself scared the wolf. Call the veterinary-psychologist!");
        }
    }
}
