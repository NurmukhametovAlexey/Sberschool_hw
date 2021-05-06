package ru.sbrf.lesson12.hw9;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UniqueNameList {
    public static void main(String[] args) {
        List<List<String>> inputList = Arrays.asList(
                Arrays.asList("Bob", "John", "Bill"),
                Arrays.asList("James", "Bill", "Michael"),
                Arrays.asList("Alan", "Bob", "Alice"),
                Arrays.asList("Julia", "Theresa", "Bill"));

        Optional<List<String>> outputList = unifyNames(inputList);
        outputList.ifPresent(System.out::println);

        Optional<List<String>>nullList = unifyNames(null);
        nullList.ifPresent(System.out::println);
    }

    public static Optional<List<String>> unifyNames(List<List<String>> nameLists) {
        if (nameLists == null || nameLists.isEmpty())
            return Optional.empty();

        Stream<List<String>> names = nameLists.stream();

        return Optional.of (
                names.flatMap(l -> l.stream())
                .distinct()
                .collect(Collectors.toList())
        );
    }
}
