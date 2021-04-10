package ru.sbrf.lesson1;

import ru.sbrf.lesson2.Operations;

public class HelloWorld {

    public static void main(String[] args) {
        var operation = new Operations();
        var a = operation.sum();
        System.out.println("Hello, world! " + a);
    }
}
