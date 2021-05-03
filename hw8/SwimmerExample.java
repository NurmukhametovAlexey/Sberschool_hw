package ru.sbrf.lesson11.hw8;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class SwimmerExample {
    public static void main(String[] args) {
        Swimmer swimmer = new Swimmer("John", 22);
        swimmer.swim(x-> System.out.println(x));

        Supplier<String> supplySwimmerName = swimmer::getName;
        System.out.println(supplySwimmerName.get());

        BiConsumer<String, Integer> setNameAndAge = (name, age) -> {swimmer.setName(name);
                                                                    swimmer.setAge(age);};
        setNameAndAge.accept("Bob", 30);
        System.out.println(supplySwimmerName.get() + " " + swimmer.getAge());
    }
}
