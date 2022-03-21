package ch15.test2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayFiller {
    public static <T> T[] fill(T[] arr, Generator<T> gen) {
        return fill(arr, gen, 0, arr.length);
    }

    public static <T> T[] fill(T[] arr, Generator<T> gen, int fromIndex, int toIndex) {
        if (fromIndex < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (toIndex > arr.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = fromIndex; i < toIndex; i++) {
            arr[i] = gen.next();
        }
        return arr;
    }

    public static <T> T[] fillHead(T[] arr, Generator<T> gen, int toIndex) {
        return fill(arr, gen, 0, toIndex);
    }

    public static <T> T[] fillTail(T[] arr, Generator<T> gen, int fromIndex) {
        return fill(arr, gen, fromIndex, arr.length);
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] fill(Generator<T> gen, Class<T> type, int size) {
        T[] arr = (T[]) Array.newInstance(type, size);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = gen.next();
        }
        return arr;
    }

    public static void main(String[] args) {
        final int SIZE = 10;
        Integer[] numbers = new Integer[SIZE];
        fill(numbers, new CommonGenerator.IntGenerator());
        System.out.println(Arrays.toString(numbers));
        numbers = fill(new RandomGenerator.IntGenerator(), Integer.class, 6);
        System.out.println(Arrays.toString(numbers));
    }

}
// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
// [55, 21, 98, 95, 40, 59]