package ru.sbrf.school.lesson15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

public class BinarySequenceTest {
    @Test
    @DisplayName("Проверка на NULL")
    public void testNullString() throws Exception {
        OptionalInt result = BinarySequence.findLongestSequenceOfOnes(null);
        Assertions.assertEquals(OptionalInt.empty(), result);
    }

    @Test
    @DisplayName("Проверка на пустой строке")
    public void testEmptyString() throws Exception {
        OptionalInt result = BinarySequence.findLongestSequenceOfOnes("");
        Assertions.assertEquals(OptionalInt.of(0), result);
    }

    @Test
    @DisplayName("Проверка на некорректные входные данные")
    public void testInvalidString() throws Exception {
        Assertions.assertThrows(RuntimeException.class,()-> {
            BinarySequence.findLongestSequenceOfOnes("1010  0101");
        });
        Assertions.assertThrows(RuntimeException.class,()-> {
            BinarySequence.findLongestSequenceOfOnes("1a");
        });
    }

    @Test
    @DisplayName("Проверка строчки из нулей")
    public void testOnlyZeroes() throws Exception {
        OptionalInt result = BinarySequence.findLongestSequenceOfOnes("0000");
        Assertions.assertEquals(OptionalInt.of(0), result);
    }

    @Test
    @DisplayName("Проверка строчки из единиц")
    public void testOnlyOnes() throws Exception {
        OptionalInt result = BinarySequence.findLongestSequenceOfOnes("1111");
        Assertions.assertEquals(OptionalInt.of(4), result);
    }

    @Test
    @DisplayName("Проверка строчки с одной последовательностью максимальной длины")
    public void testSequenceOneMax() throws Exception {
        OptionalInt result = BinarySequence.findLongestSequenceOfOnes("11100101");
        Assertions.assertEquals(OptionalInt.of(3), result);
    }

    @Test
    @DisplayName("Проверка строчки с несколькими последовательностями максимальной длины")
    public void testSequenceMultipleMax() throws Exception {
        OptionalInt result = BinarySequence.findLongestSequenceOfOnes("11001100");
        Assertions.assertEquals(OptionalInt.of(2), result);
    }
}
