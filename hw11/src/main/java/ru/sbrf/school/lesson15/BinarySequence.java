package ru.sbrf.school.lesson15;

import java.util.OptionalInt;

public class BinarySequence {
    public static OptionalInt findLongestSequenceOfOnes(String sequence) throws RuntimeException {
        if (sequence == null)
            return OptionalInt.empty();

        if (!correctBinarySequence(sequence))
            throw new RuntimeException();

        int len = 0;
        int tmp = 0;

        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == '1') {
                tmp++;
            }
            len = Integer.max(len, tmp);
            if (sequence.charAt(i) == '0') {
                tmp = 0;
            }
        }
        return OptionalInt.of(len);
    }

    private static boolean correctBinarySequence(String sequence) {
        for (char l: sequence.toCharArray()) {
            if (l != '0' && l != '1')
                return false;
        }
        return true;
    }
}
