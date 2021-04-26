package ru.sbrf.lesson7.hw7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IntegerSequence implements Iterable<Integer> {
    public List<Integer> intSequence;

    public IntegerSequence() {
        intSequence = new ArrayList<Integer>();
    }

    public void addInteger(int integer) {
        intSequence.add(integer);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new DigitIterator();
    }

    public class DigitIterator implements Iterator<Integer> {
        private int posInList;
        private int posInInt;

        public DigitIterator() {
            posInList = 0;
            posInInt = 0;
        }

        @Override
        public boolean hasNext() {
            while (posInList < intSequence.size()) {
                int currentInt = Math.abs(intSequence.get(posInList));

                int digitsInInt = (int) (Math.log10(currentInt) + 1);
                if (posInInt < digitsInInt) {
                    posInInt++;
                    return true;
                }
                else {
                    posInList++;
                    posInInt = 0;
                }
            }
            return false;
        }

        @Override
        public Integer next() {
            int currentInt = Math.abs(intSequence.get(posInList));
            return (int)(currentInt/Math.pow(10,posInInt-1)%10);
        }
    }
}
