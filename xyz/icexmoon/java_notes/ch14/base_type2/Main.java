package ch14.base_type2;

import java.util.Arrays;
import java.util.Random;

interface Generator<T> {
    T next();
}

class IntGenerator implements Generator<Integer> {
    private static Random random = new Random();
    private int bound;
    private static final int DEFAULT_BOUND = 100;

    public IntGenerator() {
        this(DEFAULT_BOUND);
    }

    public IntGenerator(int bound) {
        if (bound > 0) {
            this.bound = bound;
        }
    }

    @Override
    public Integer next() {
        return random.nextInt(bound);
    }

}

public class Main {
    public static void main(String[] args) {
        final int SIZE = 10;
        Integer[] numbers = fillArray(new Integer[SIZE], new IntGenerator());
        System.out.println(Arrays.toString(numbers));
        // Integer[] numbers2 = fillArray(new int[SIZE], new IntGenerator());
        // The method fillArray(T[], Generator<T>) in the type Main is not applicable
        // for the arguments (int[], IntGenerator)Java(67108979)
    }

    private static <T> T[] fillArray(T[] array, Generator<T> generator) {
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.next();
        }
        return array;
    }
}
