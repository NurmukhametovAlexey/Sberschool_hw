package ru.sbrf.lesson3.hw3and4.zoo.enclosure;

import ru.sbrf.lesson3.hw3and4.zoo.animal.Animal;
import ru.sbrf.lesson3.hw3and4.zoo.exception.AnimalDuplicateException;
import ru.sbrf.lesson3.hw3and4.zoo.exception.EnclosureFullException;
import ru.sbrf.lesson3.hw3and4.zoo.exception.EnclosureNotFoundException;
import ru.sbrf.lesson3.hw3and4.zoo.exception.ZooFullException;

import java.util.LinkedHashMap;
import java.util.Map;

public class ZooEnclosures {
    private int enclosuresMaxCount;
    private LinkedHashMap<String, Enclosure> enclosureHashMap;

    public ZooEnclosures(int enclosuresMaxCount) {
        this.enclosuresMaxCount = enclosuresMaxCount;
        enclosureHashMap = new LinkedHashMap<>(enclosuresMaxCount);
    }

    public ZooEnclosures() {
        this(4);
    }

    public void addEnclosure(String name, int capacity) throws ZooFullException {
        if (enclosureHashMap.size() >= enclosuresMaxCount)
            throw new ZooFullException("Zoo has no place for another enclosure!");
        else
            enclosureHashMap.put(name, new Enclosure(capacity));
    }

    public void addEnclosure(String name) throws ZooFullException {
        if (enclosureHashMap.size() >= enclosuresMaxCount)
            throw new ZooFullException("Zoo has no place for another enclosure!");
        else
            enclosureHashMap.put(name, new Enclosure());
    }

    public void addEnclosure(int capacity) throws ZooFullException {
        if (enclosureHashMap.size() >= enclosuresMaxCount)
            throw new ZooFullException("Zoo has no place for another enclosure!");
        else
            enclosureHashMap.put("Enclosure " + (Enclosure.getEnclosuresCount()+1), new Enclosure(capacity));
    }

    public void addEnclosure() throws ZooFullException {
        if (enclosureHashMap.size() >= enclosuresMaxCount)
            throw new ZooFullException("Zoo has no place for another enclosure!");
        else
            enclosureHashMap.put("Enclosure " + (Enclosure.getEnclosuresCount()+1), new Enclosure());
    }

    public void addAnimalToEnclosure(String enclosureName, Animal animal) throws EnclosureNotFoundException,
            EnclosureFullException, AnimalDuplicateException {
        if (!enclosureHashMap.containsKey(enclosureName))
            throw new EnclosureNotFoundException("Enclosure \"" + enclosureName + "\" not found!");

        for (Map.Entry<String, Enclosure> entry : enclosureHashMap.entrySet()) {
            if (entry.getValue().contains(animal))
                throw new AnimalDuplicateException("This animal is already present in enclosure " + entry.getKey());
        }

        enclosureHashMap.get(enclosureName).addAnimal(animal);
    }

    public void printEnclosuresState() {
        System.out.println("Zoo has " + enclosureHashMap.size() + " enclosures:");
        for (var entry : enclosureHashMap.entrySet()) {
            System.out.println("\nEnclosure \"" + entry.getKey() + "\"");
            entry.getValue().printAnimals();
        }
    }
}
