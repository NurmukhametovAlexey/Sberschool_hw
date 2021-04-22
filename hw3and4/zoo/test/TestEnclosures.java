package ru.sbrf.lesson3.hw3and4.zoo.test;

import ru.sbrf.lesson3.hw3and4.zoo.animal.*;
import ru.sbrf.lesson3.hw3and4.zoo.enclosure.Enclosure;
import ru.sbrf.lesson3.hw3and4.zoo.exception.*;

public class TestEnclosures {

    public void testEnclosure() {
        System.out.println("TESTING BASIC FUNCTIONALITY:\n");

        System.out.println("\nBasic functionality:\n");
        Enclosure enclosure = new Enclosure();

        Bear bear = new Bear("Bear1", 10);
        Lion lion = new Lion("Lion1", 20);
        Wolf wolf = new Wolf("Wolf1", 15);
        Monkey monkey = new Monkey("Monkey1", 7);

        enclosure.addAnimal(bear);
        enclosure.addAnimal(lion);
        enclosure.addAnimal(wolf);
        enclosure.addAnimal(monkey);

        enclosure.printAnimals();

        enclosure.removeAnimal(bear);
        enclosure.removeAnimal(lion);

        System.out.println("\n\"bear\" and \"lion\" removed: \n");

        enclosure.printAnimals();

        System.out.println("\nTESTING \"EnclosureFullException\":");
        Enclosure enclosure2 = new Enclosure(2);

        try {
            enclosure2.addAnimal(bear);
            enclosure2.addAnimal(lion);
            enclosure2.addAnimal(wolf);
        }
        catch (EnclosureFullException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("\nTESTING \"AnimalDuplicateException\":\n");
        Enclosure enclosure3 = new Enclosure(2);

        try {
            enclosure3.addAnimal(bear);
            enclosure3.addAnimal(bear);
        }
        catch (AnimalDuplicateException e) {
            System.err.println(e.getMessage());
        }
    }

}
