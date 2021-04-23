package ru.sbrf.lesson6.hw6;

import java.util.LinkedHashSet;
import java.util.Set;

public class MyIntegerDifferentDigitsOrder implements Comparable<MyIntegerDifferentDigitsOrder>{
    private int integer;
    private Set<Integer> digitsSet;

    public MyIntegerDifferentDigitsOrder(int integer) {
        this.integer = integer;
        digitsSet = new LinkedHashSet<Integer>();
        intToDigitsSet(integer);
    }

    public MyIntegerDifferentDigitsOrder(double d) {  this((int) d);  }

    public MyIntegerDifferentDigitsOrder(Number n) {  this(n.intValue());  }

    public MyIntegerDifferentDigitsOrder() {  this(0);  }

    public MyIntegerDifferentDigitsOrder(MyIntegerDifferentDigitsOrder myInt) {  this(myInt.getInteger());  }

    public int getInteger() {
        return integer;
    }

    public int getDifferentDigitsSize() {
        return digitsSet.size();
    }

    public void printDigits() {
        for (var el : digitsSet)
            System.out.print(el + " ");
        System.out.println("");
    }

    void intToDigitsSet(int integer) {
        for (char c : Integer.toString(Math.abs(integer)).toCharArray())
            digitsSet.add(Character.getNumericValue(c) - Character.getNumericValue('0'));
    }

    @Override
    public int compareTo(MyIntegerDifferentDigitsOrder o) {
        return Integer.compare(this.digitsSet.size(), o.digitsSet.size());
    }

    @Override
    public String toString() {
        return Integer.toString(integer);
    }
}
