package ru.sbrf.lesson12.hw9;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AverageWeight {
    public static void main(String[] args) {

        Map<String, Double> weightMap = new HashMap<>();
        weightMap.put("First", 10.0);
        weightMap.put("Second", 0.0);
        weightMap.put("Third", 5.0);

        avgWeight(weightMap).ifPresent(System.out::println);

        Map<String, Double> emptyMap = new HashMap<>();

        avgWeight(emptyMap).ifPresent(System.out::println);
    }

    public static Optional<Double> avgWeight(Map<String, Double> inputMap) {
        if (inputMap == null || inputMap.isEmpty())
            return Optional.empty();

        return Optional.of (
                inputMap.entrySet().stream()
                .map(a -> a.getValue())
                .reduce(0.0, (a, b) -> a+b) / inputMap.size()
        );
    }
}
