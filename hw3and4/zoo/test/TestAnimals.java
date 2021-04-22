package ru.sbrf.lesson3.hw3and4.zoo.test;

import ru.sbrf.lesson3.hw3and4.zoo.animal.*;
import ru.sbrf.lesson3.hw3and4.zoo.animal.interfaces.*;
import ru.sbrf.lesson3.hw3and4.zoo.exception.AnimalHurtException;
import ru.sbrf.lesson3.hw3and4.zoo.exception.VisitorHurtException;
import ru.sbrf.lesson3.hw3and4.zoo.exception.VisitorOffendedException;

public class TestAnimals {

    public void testAllAnimals() {
        Bear bear = new Bear("Bear1", 10);
        Lion lion = new Lion("Lion1", 20);
        Wolf wolf = new Wolf("Wolf1", 15);
        Monkey monkey = new Monkey("Monkey1", 7);
        Zebra zebra = new Zebra("Zebra1", 30);
        Duck duck = new Duck("Duck1", 3);
        Parrot parrot = new Parrot("Parrot1", 1);

        Animal[] animalsToTest = {bear, lion, wolf, monkey, zebra, duck, parrot};

        TestEnclosures animalTests = new TestEnclosures();

        for (Animal animal: animalsToTest) {
            System.out.println("\nTesting animal " + animal.getClass());

            testAnimal(animal);
            if (animal instanceof Walkable)
                testWalkable((Walkable) animal);
            if (animal instanceof Swimmable)
                testSwimmable((Swimmable) animal);
            if (animal instanceof Flyable)
                testFlyable((Flyable) animal);
            if (animal instanceof Vegetarian)
                testVegetarian((Vegetarian) animal);
            if (animal instanceof Dangerous)
                testDangerous((Dangerous) animal);
        }
    }

    public void testAnimal(Animal animal) {
        System.out.println("animal.getName()\n" + animal.getName());
        System.out.println("animal.getAge()\n" + animal.getName());
        System.out.println("animal.say()...");
        animal.say();
        System.out.println("animal.feed()...");
        animal.feed();
        System.out.println("animal.feed(treats)...");
        animal.feed("treats");
        System.out.println("animal.celebrateBDay()...");
        animal.celebrateBDay();
    }
    public void testWalkable(Walkable walkable) {
        System.out.println("walkable.walk()...");
        walkable.walk();
    }

    public void testSwimmable(Swimmable swimmable) {
        System.out.println("swimmable.swim()...");
        swimmable.swim();
    }

    public void testFlyable(Flyable flyable) {
        System.out.println("flyable.fly()...");
        flyable.fly();
        System.out.println("flyable.land()...");
        flyable.land();
    }

    public void testVegetarian(Vegetarian vegetarian) {
        System.out.println("vegetarian.eatFromVisitor()");
        try{
            vegetarian.eatFromVisitor();
        }
        catch (VisitorHurtException e) {
            System.err.println("\"VisitorHurtException\" for " + vegetarian.getClass());
            System.err.println(e.getMessage());
        }
        catch (VisitorOffendedException e) {
            System.err.println("\"VisitorOffendedException\" for " + vegetarian.getClass());
            System.err.println(e.getMessage());
        }
        catch (AnimalHurtException e) {
            System.err.println("\"AnimalHurtException\" for " + vegetarian.getClass());
            System.err.println(e.getMessage());
        }
    }

    public void testDangerous(Dangerous dangerous) {
        System.out.println("dangerous.attack()");
        try {
            dangerous.attack();
        }
        catch (VisitorHurtException e) {
            System.err.println("\"VisitorHurtException\" for " + dangerous.getClass());
            System.err.println(e.getMessage());
        }
    }

}
