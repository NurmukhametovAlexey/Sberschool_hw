package ru.sbrf.lesson11.hw8;

import java.util.Arrays;
import java.util.List;

public class MethodsLibraryExamples {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        System.out.println("Initial list: " + list1);

        List<String> res1 = MethodsLibrary.map(list1, (Integer num) -> {return "a".repeat(num);});
        System.out.println("map \"a\".repeat(num):");
        System.out.println(res1);

        System.out.println("forEach println:");
        MethodsLibrary.forEach(list1, System.out::println);

        List<Integer> res2 = MethodsLibrary.filter(list1, num -> (num >= 2));
        System.out.println("filter (num >= 2):");
        System.out.println(res2);

        System.out.println("sum:");
        System.out.println(MethodsLibrary.sum(list1));

        System.out.println("Counting even elements: " + MethodsLibrary.count(list1, a -> (a%2==0)));

        System.out.println("foldLeft: " + MethodsLibrary.foldLeft(list1, (a,b)->(int)Math.pow(a,b)));

        System.out.println("foldRight: " + MethodsLibrary.foldRight(list1, (a,b)->(int)Math.pow(a,b)));
    }
}
