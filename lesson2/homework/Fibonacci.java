package ru.sbrf.lesson2.homework;
import java.util.Scanner;
/**
 * The Fibonacci class is for representing decimal numbers in Fibonacci numeral system
 */
public class Fibonacci {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long decimalNum = scanner.nextLong();

        if (decimalNum == 0) {
            System.out.println(0);
            return;
        }
// seqLen is set to 90 as it is the last element that fits into long
        final int seqLen = 90;
        long[] fibSequence = new long[seqLen];
        fibSequence[0] = 1;
        fibSequence[1] = 2;
        for(int i = 2; i<seqLen; i++)
            fibSequence[i] = fibSequence[i-2] + fibSequence[i-1];

        String fibSysNum = "";

        for (int i = seqLen-1; i >= 0; i--) {
            if (fibSequence[i] <= decimalNum) {
                fibSysNum += "1";
                decimalNum -= fibSequence[i];
            }
            else if (!fibSysNum.isEmpty())
                fibSysNum += "0";
        }
        System.out.println(fibSysNum);
    }
}