package ch15.test2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayFiller {
    public static <T> T[] fill(T[] arr, Generator<T> gen) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = gen.next();
        }
        return arr;
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