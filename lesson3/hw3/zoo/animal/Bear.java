package ru.sbrf.lesson3.hw3.zoo.animal;

import java.util.concurrent.ThreadLocalRandom;

public class Bear extends Animal implements Walkable, Swimmable, Dangerous{

    double dangerousness;


    public Bear(String name, int age) {
        super(name, age);
        dangerousness = 0.5;
    }

    @Override
    public void say() {
        System.out.println("Roar!");
    }

    @Override
    public void feed() {
        System.out.println("Feeding bear with fish");
    }

    @Override
    public void feed(String treats) {
        System.out.println("Feeding bear with " + treats);
    }

    @Override
    public void swim() {
        System.out.println("The bear swims");
    }

    @Override
    public void walk() {
        System.out.println("The bear walks");
    }

    @Override
    public void attack() {
        double outcome = ThreadLocalRandom.current().nextDouble(1);
        if (outcome < dangerousness) {
            System.out.println("Visitor came to close! Bear attacked and caused severe injuries!");
        }
        else {
            System.out.println("Visitor managed to dodge bear`s attack. What a relief!");
        }
    }
}
