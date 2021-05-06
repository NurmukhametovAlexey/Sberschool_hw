package ru.sbrf.lesson12.hw9;

import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PositiveNegativeStream {
    public static void main(String[] args) {
        Stream<Integer> pnInfinite = Stream.generate(() -> ThreadLocalRandom.current().nextInt(-100, 100));

        System.out.println("Filtered mapped stream:");
        Set<Integer> mySet = pnInfinite
                .filter(a -> (a > 0 && a % 2 == 1))
                .map(a -> a * 2)
                .peek(a -> System.out.print(a + " "))
                .limit(15)
                .collect(Collectors.toSet());

        System.out.println("\nSaved set:");
        System.out.println(mySet);

        System.out.println("Finding sum:");
        Integer sum = mySet.stream()
                .reduce(0, (a,b) -> a+b);
        System.out.println(sum);
    }
}
