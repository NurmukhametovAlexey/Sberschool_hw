package ru.sbrf.lesson12.hw9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListsIntersection {
    public static void main(String[] args) {

        List<Long> inputList1 = Arrays.asList(123L, -5L, 0L, 0L, 78956L, 11L, 11L);
        List<Long> inputList2 = Arrays.asList(123L, -5L, 0L, 542L, 11L, 0L);

        intersect(inputList1, inputList2).ifPresent(System.out::println);

        intersect(new ArrayList<Long>(), null).ifPresent(System.out::println);
    }

// works not only with lists of longs
    public static <T> Optional<List<T>> intersect(List<T> first, List<T> second) {

        if (first == null || second == null || first.isEmpty() || second.isEmpty())
            return Optional.empty();

        List<T> secondCopy = new ArrayList<>(second);

        Stream<T> firstStream = first.stream();

        return Optional.of(
        firstStream.filter( a -> { boolean contains = secondCopy.stream().anyMatch(b -> b.equals(a));
                                   if (contains) secondCopy.remove(a);
                                   return contains; } )
                .collect(Collectors.toList())
        );
    }
}
