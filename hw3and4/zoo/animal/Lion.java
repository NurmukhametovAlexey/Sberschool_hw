package ru.sbrf.lesson3.hw3and4.zoo.animal;

import ru.sbrf.lesson3.hw3and4.zoo.animal.interfaces.Dangerous;
import ru.sbrf.lesson3.hw3and4.zoo.animal.interfaces.Walkable;
import ru.sbrf.lesson3.hw3and4.zoo.exception.VisitorHurtException;

import java.util.concurrent.ThreadLocalRandom;

public class Lion extends Animal implements Walkable, Dangerous {

    double dangerousness;

    public Lion(String name, int age) {
        super(name, age);
        dangerousness = 0.75;
    }

    @Override
    public void say() {
        System.out.println("Snarl!");
    }

    @Override
    public void feed() {
        System.out.println("Feeding lion with meat");
    }

    @Override
    public void feed(String treats) {
        System.out.println("Feeding lion with " + treats);
    }

    @Override
    public void walk() {
        System.out.println("The lion walks with grace");
    }

    @Override
    public void attack() {
        double outcome = ThreadLocalRandom.current().nextDouble(1);
        if (outcome < dangerousness) {
            System.out.println("Visitor came to close! Lion killed the poor man!");
            throw new VisitorHurtException("Visitor came to close! Lion killed the poor man!");
        }
        else {
            System.out.println("Visitor managed to escape the lion. Shit his pants though!");
        }
    }
}
