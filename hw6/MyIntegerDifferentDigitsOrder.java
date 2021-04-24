package ru.sbrf.lesson6.hw6;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class MyIntegerDifferentDigitsOrder implements Comparable<MyIntegerDifferentDigitsOrder>{
    private int integer;

    public MyIntegerDifferentDigitsOrder(int integer) {
        this.integer = integer;
    }

    public MyIntegerDifferentDigitsOrder(double d) {  this((int) d);  }

    public MyIntegerDifferentDigitsOrder(Number n) {  this(n.intValue());  }

    public MyIntegerDifferentDigitsOrder() {  this(0);  }

    public MyIntegerDifferentDigitsOrder(MyIntegerDifferentDigitsOrder myInt) {  this(myInt.getInteger());  }

    public int getInteger() {
        return integer;
    }

    private Set<Integer> intToDigitsSet() {
        Set<Integer> digitsSet = new HashSet<>();
        for (char c : Integer.toString(Math.abs(integer)).toCharArray())
            digitsSet.add(Character.getNumericValue(c) - Character.getNumericValue('0'));
        return digitsSet;
    }

    public void printDigits() {
        for (var el : intToDigitsSet())
            System.out.print(el + " ");
        System.out.println("");
    }

    @Override
    public int compareTo(MyIntegerDifferentDigitsOrder o) {
        int result = Integer.compare(this.intToDigitsSet().size(), o.intToDigitsSet().size());
        if (result == 0)
            return Integer.compare(this.integer, o.integer);
        else
            return result;
    }

    @Override
    public String toString() {
        return Integer.toString(integer);
    }
}
