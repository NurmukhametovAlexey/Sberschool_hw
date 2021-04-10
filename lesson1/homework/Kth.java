package ru.sbrf.lesson1.homework;

import java.util.Scanner;

/**
 * The Kth class is for calculating the K-th digit in an infinite natural numbers string
 */
public class Kth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    // +1 is here to start counting from 1 instead of 0
        long k = sc.nextLong() + 1;
        long numLen = 1;
    // Calculate the length of natural numbers around the position k
        while (naturalsStrLen(numLen) < k)
            numLen++;
    // Calculate the difference between k and position of the first numLen-digit number 10^(numLen-1)
        k -= naturalsStrLen(numLen-1);

        long neededNumber = power(10, numLen-1);
    // Starting from 10^(numLen-1) calculate how many whole numLen-digit numbers stand before our needed number in pos k
        neededNumber += (k-1)/numLen;
        k -= (k-1)/numLen * numLen;
    // We got to our needed number. It`s only left to calculate the exact digit of it
        neededNumber = (neededNumber%power(10,numLen-k+1)/power(10,numLen-k));

        System.out.println(neededNumber);
    }

    /**
     * Calculate the number of characters in the string of natural numbers from 1 to 9..9 (length of 9..9 is defined via
     * naturalLen). This value can be expressed as follows: 9*10^(n-1) denotes the amount of all numbers of length n,
     * 9*10^(n-1)*n denotes the length of all numbers of length n written in a string
     * sum over n*9*10^(n-1) for n from 1 to naturalLen gives the return value. It can be shown that:
     * [sum over n*9*10^(n-1) for n from 1to naturalLen] = (10^(naturalLen)*(9*naturalLen - 1) + 1)/9
     *
     * @param  naturalLen   maximal length of a decimal numbers in string
     * @return              length of the string consisting of all consecutive numbers of length from 1 to naturalLen
     */
    public static long naturalsStrLen(long naturalLen){
        if (naturalLen < 1)
            return 0;
        return (power(10,naturalLen)*(9*naturalLen-1)+1)/9;
    }

    /**
     * Calculate the exponentiation with non-negative powers only.
     *
     * @param  base   exponent base
     * @param  pow    power of the exponent
     * @return        long power = base^pow
     */
    public static long power(long base, long pow) {
        if (pow < 0)
            return 0;
        else if (pow == 0)
            return 1;
        else if (pow%2 ==0)
            return power(base*base,pow/2);
        else
            return base*power(base,pow-1);
    }

}
