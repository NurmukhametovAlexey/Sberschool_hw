package ru.sbrf.lesson7.hw7;

import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class MyMatrix implements Iterable<Integer>{
    private final int rows;
    private final int cols;
    private int[][] matrix;

    public MyMatrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new int[rows][cols];
    }

    public void setElement(int i, int j, int value) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            System.err.println("Indeces out of bounds!");
            return;
        }
        matrix[i][j] = value;
    }

    public void randomFill() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = ThreadLocalRandom.current().nextInt(0,10);
            }
        }
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new SpiralIterator();
    }



    public class SpiralIterator implements Iterator<Integer> {

        int currentI;
        int currentJ;
        int elementsCount;

        public SpiralIterator() {
            currentI = -1;
            currentJ = 0;
            elementsCount = 0;
        }

        @Override
        public boolean hasNext() {
            if (elementsCount >= rows * cols)
                return false;

            if (inLeftPart(currentI, currentJ)) {
                currentI++;
            }
            else if (inDownPart(currentI, currentJ)) {
                currentJ++;
            }
            else if (inRightPart(currentI, currentJ)) {
                currentI--;
            }
            else if (inUpPart(currentI, currentJ)) {
                currentJ--;
            }
            elementsCount++;
            return true;
        }

        @Override
        public Integer next() {
            return matrix[currentI][currentJ];
        }

        private boolean inLeftPart(int i, int j) {
            return ( j <= i+1 && j<rows-1-i && j < cols/2 + cols%2);
        }

        private boolean inDownPart(int i, int j) {
            return ( j >= rows-1-i && j < i+cols-rows  && i >= rows/2);
        }

        private boolean inRightPart(int i, int j) {
            return (j >= i+cols-rows && j > cols-1-i && j >= cols/2 + cols%2);
        }

        private boolean inUpPart(int i, int j) {
            return (j <= cols-1-i && j > i+1  && i < rows/2) ;
        }
    }
}
