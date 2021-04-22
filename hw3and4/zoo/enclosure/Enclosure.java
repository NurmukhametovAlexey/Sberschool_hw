package ru.sbrf.lesson3.hw3and4.zoo.enclosure;

import ru.sbrf.lesson3.hw3and4.zoo.animal.Animal;
import ru.sbrf.lesson3.hw3and4.zoo.exception.AnimalDuplicateException;
import ru.sbrf.lesson3.hw3and4.zoo.exception.EnclosureFullException;

import java.util.HashSet;
import java.util.Set;

public class Enclosure {

    private static int enclosuresCount;

    public static int getEnclosuresCount() {
        return enclosuresCount;
    }

    private int enclosureID;
    private int enclosureSize;
    private Set<Animal> animalsInside;

    static {
        enclosuresCount = 0;
    }

    public Enclosure(int capacity) {
        enclosureSize = capacity;
        animalsInside = new HashSet<Animal>(enclosureSize);
        enclosureID = ++enclosuresCount;
    }

    public Enclosure() {
        this(4);
    }

    public int getEnclosureID() {
        return enclosureID;
    }

    public void addAnimal(Animal animal) throws EnclosureFullException, AnimalDuplicateException  {
        if(animalsInside.size() >= enclosureSize)
            throw new EnclosureFullException("Enclosure " + enclosureID + " is already full!");
        else if (!animalsInside.add(animal))
            throw new AnimalDuplicateException("Error trying to add the same animal twice!");
    }

    public void removeAnimal(Animal animal) {
        if (animalsInside.contains(animal))
            animalsInside.remove(animal);
        else
            System.err.println("No such animal in the enclosure!s");
    }

    public void printAnimals() {
        System.out.println("Enclosure #" + enclosureID + ". Animals inside:");
        for (var animal : animalsInside)
            System.out.println(animal.getClass() + " " + animal.getName());
        if (animalsInside.isEmpty())
            System.out.println("EMPTY");
    }

    public boolean contains(Animal animal) {
        for (Animal an : animalsInside)
            if (an.equals(animal))
                return true;
        return false;
    }

}
