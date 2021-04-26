package ru.sbrf.lesson7.hw7;

import java.util.Iterator;

public class IntegerSequenceIteratorExample {
    public static void main(String[] args) {
        IntegerSequence mySequence = new IntegerSequence();

        mySequence.addInteger(1234);
        mySequence.addInteger(9876);
        mySequence.addInteger(-1234);

        for (Iterator<Integer> it = mySequence.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }
}
