package ru.sbrf.lesson11.hw8;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MethodsLibrary {

    static <T, R> List<R> map (List<T> origin, Function<T, R> mapper) {
        List<R> retList = new ArrayList<>();
        for (T element: origin) {
            retList.add(mapper.apply(element));
        }
        return retList;
    }

    static <T> void forEach(List<T> origin, Consumer<T> consumer) {
        for (T element : origin)
            consumer.accept(element);
    }

    static <T> List<T> filter(List<T> origin, Predicate<T> predicate) {
        List<T> retList = new ArrayList<>();
        for (T element : origin) {
            if (predicate.test(element))
                retList.add(element);
        }
        return retList;
    }

    static <T extends Number> T sum(List<T> origin) {
        Double sum = 0.0;
        for (T el : origin) {
            sum += el.doubleValue();
        }
        return (T)sum;
    }

    static <T> Integer count(List<T> origin, Predicate<T> predicate) {
        Integer cnt = 0;
        for (T element : origin) {
            if (predicate.test(element)) {
                cnt++;
            }
        }
        return cnt;
    }

    static <T> T foldLeft(List<T> origin, BinaryOperator<T> operator) {
        T result = (T)null;
        ListIterator<T> it = origin.listIterator();

        if (it.hasNext())
            result = it.next();

        while (it.hasNext()) {
            result = operator.apply(result, it.next());
        }
        return result;
    }

    static <T> T foldRight(List<T> origin, BinaryOperator<T> operator) {
        T result = (T)null;
        ListIterator<T> it = origin.listIterator(origin.size());

        if (it.hasPrevious())
            result = it.previous();

        while (it.hasPrevious()) {
            result = operator.apply(result, it.previous());
        }
        return result;
    }
}
