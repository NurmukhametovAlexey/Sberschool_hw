package ru.sbrf.lesson6.hw6;

import java.util.ArrayList;

public class MyIntegerPrimeFactorsOrder implements Comparable<MyIntegerPrimeFactorsOrder>{
    private int integer;
    private ArrayList<Integer> primeFactors;

    public MyIntegerPrimeFactorsOrder(int integer) {
        this.integer = integer;
        primeFactors = new ArrayList<Integer>();
        factorize();
    }

    public MyIntegerPrimeFactorsOrder(double d) {  this((int) d);  }

    public MyIntegerPrimeFactorsOrder(Number n) {  this(n.intValue());  }

    public MyIntegerPrimeFactorsOrder() {  this(0);  }

    public MyIntegerPrimeFactorsOrder(MyIntegerPrimeFactorsOrder myInt) {  this(myInt.getInteger());  }

    public int getInteger() {
        return integer;
    }

    public int getPrimeFactorsSize() {
        return primeFactors.size();
    }

    public ArrayList<Integer> getPrimeFactors() {
        return new ArrayList<Integer>(primeFactors);
    }

    public void printPrimeFactors() {
        if (primeFactors.isEmpty()) {
            System.out.println("None");
            return;
        }
        for (var el : primeFactors)
            System.out.print(el + " ");
        System.out.println("");
    }

    private void factorize() {
        int tmp = Math.abs(integer);
        for (int i = 2; tmp > 1; ) {
            if (tmp % i == 0) {
                primeFactors.add(i);
                tmp /= i;
            }
            else
                i++;
        }
    }

    @Override
    public int compareTo(MyIntegerPrimeFactorsOrder o) {
        return Integer.compare(this.primeFactors.size(), o.primeFactors.size());
    }

    @Override
    public String toString() {
        return Integer.toString(integer);
    }
}
