package ru.sbrf.lesson3.hw3and4.zoo.test;

import ru.sbrf.lesson3.hw3and4.zoo.animal.*;
import ru.sbrf.lesson3.hw3and4.zoo.enclosure.ZooEnclosures;
import ru.sbrf.lesson3.hw3and4.zoo.exception.AnimalDuplicateException;
import ru.sbrf.lesson3.hw3and4.zoo.exception.EnclosureNotFoundException;
import ru.sbrf.lesson3.hw3and4.zoo.exception.ZooFullException;

public class TestZooEnclosures {
    public void testZooEnclosures() {
        System.out.println("TESTING BASIC FUNCTIONALITY:\n");

        ZooEnclosures zooEnclosures = new ZooEnclosures();

        zooEnclosures.addEnclosure();
        zooEnclosures.addEnclosure("myEnclosure", 2);
        zooEnclosures.addEnclosure(3);
        zooEnclosures.addEnclosure("LastOne");

        Bear bear = new Bear("Bear1", 10);
        Lion lion = new Lion("Lion1", 20);
        Wolf wolf = new Wolf("Wolf1", 15);
        Monkey monkey = new Monkey("Monkey1", 7);

        zooEnclosures.addAnimalToEnclosure("myEnclosure", bear);
        zooEnclosures.addAnimalToEnclosure("LastOne", lion);
        zooEnclosures.addAnimalToEnclosure("Enclosure 1", wolf);
        zooEnclosures.addAnimalToEnclosure("Enclosure 3", monkey);

        zooEnclosures.printEnclosuresState();

        System.out.println("TESTING \"ZooFullException\":\n");

        try {
            zooEnclosures.addEnclosure();
        }
        catch (ZooFullException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("TESTING \"EnclosureNotFoundException\":\n");

        try {
            Duck duck = new Duck("Duck1", 2);
            zooEnclosures.addAnimalToEnclosure("absentEnclosure", duck);
        }
        catch (EnclosureNotFoundException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("TESTING \"AnimalDuplicateException\":\n");

        try {
            zooEnclosures.addAnimalToEnclosure("myEnclosure", lion);
        }
        catch (AnimalDuplicateException e) {
            System.err.println(e.getMessage());
        }
    }
}
