package ru.sbrf.lesson6.hw6;

import java.util.ArrayList;

public class MyIntegerPrimeFactorsOrder implements Comparable<MyIntegerPrimeFactorsOrder>{
    private int integer;

    public MyIntegerPrimeFactorsOrder(int integer) {
        this.integer = integer;
    }

    public MyIntegerPrimeFactorsOrder(double d) {  this((int) d);  }

    public MyIntegerPrimeFactorsOrder(Number n) {  this(n.intValue());  }

    public MyIntegerPrimeFactorsOrder() {  this(0);  }

    public MyIntegerPrimeFactorsOrder(MyIntegerPrimeFactorsOrder myInt) {  this(myInt.getInteger());  }

    public int getInteger() {
        return integer;
    }

    public void printPrimeFactors() {
        ArrayList<Integer> primeFactors = factorize();
        if (primeFactors.isEmpty()) {
            System.out.println("None");
            return;
        }
        for (var el : primeFactors)
            System.out.print(el + " ");
        System.out.println("");
    }

    private ArrayList<Integer> factorize() {
        ArrayList<Integer> primeFactors = new ArrayList<Integer>();
        int tmp = Math.abs(integer);
        for (int i = 2; tmp > 1; ) {
            if (tmp % i == 0) {
                primeFactors.add(i);
                tmp /= i;
            }
            else
                i++;
        }
        return primeFactors;
    }

    @Override
    public int compareTo(MyIntegerPrimeFactorsOrder o) {
        int result =  Integer.compare(this.factorize().size(), o.factorize().size());
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
