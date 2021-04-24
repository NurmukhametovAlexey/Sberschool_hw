package ru.sbrf.lesson6.hw6;

import java.util.TreeSet;

public class MyIntegerExamples {
    public static void main(String[] args) {
        testMyIntegerPrimeFactorsOrder();
        System.out.println("");
        testMyIntegerDifferentDigitsOrder();
    }

    public static void testMyIntegerPrimeFactorsOrder() {
        MyIntegerPrimeFactorsOrder int1 = new MyIntegerPrimeFactorsOrder(31);
        MyIntegerPrimeFactorsOrder int2 = new MyIntegerPrimeFactorsOrder(17*17);
        MyIntegerPrimeFactorsOrder int3 = new MyIntegerPrimeFactorsOrder(16);
        MyIntegerPrimeFactorsOrder int4 = new MyIntegerPrimeFactorsOrder(0);
        MyIntegerPrimeFactorsOrder int5 = new MyIntegerPrimeFactorsOrder(29);

        TreeSet<MyIntegerPrimeFactorsOrder> mipfo = new TreeSet<>();
        mipfo.add(int1);
        mipfo.add(int2);
        mipfo.add(int3);
        mipfo.add(int4);
        mipfo.add(int5);

        System.out.println("MyIntegerPrimeFactorsOrder sorted:");
        for (var el : mipfo) {
            System.out.print(el + "\t->\tprime factor(s): ");
            el.printPrimeFactors();
        }
    }

    public static void testMyIntegerDifferentDigitsOrder() {
        MyIntegerDifferentDigitsOrder int1 = new MyIntegerDifferentDigitsOrder(312);
        MyIntegerDifferentDigitsOrder int2 = new MyIntegerDifferentDigitsOrder(11119);
        MyIntegerDifferentDigitsOrder int3 = new MyIntegerDifferentDigitsOrder(-1568);
        MyIntegerDifferentDigitsOrder int4 = new MyIntegerDifferentDigitsOrder(0);
        MyIntegerDifferentDigitsOrder int5 = new MyIntegerDifferentDigitsOrder(156);

        TreeSet<MyIntegerDifferentDigitsOrder> middo = new TreeSet<>();
        middo.add(int1);
        middo.add(int2);
        middo.add(int3);
        middo.add(int4);
        middo.add(int5);

        System.out.println("MyIntegerDifferentDigitsOrder sorted:");
        for (var el : middo) {
            System.out.print(el + "\t->\tdifferent digit(s): ");
            el.printDigits();
        }
    }
}
