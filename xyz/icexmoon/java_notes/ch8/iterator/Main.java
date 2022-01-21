package ch8.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

class RandomNumbers implements Iterable<Integer> {
    private static Random random = new Random();
    private int[] numbers;

    public RandomNumbers(int size) {
        if (size <= 0) {
            throw new Error();
        }
        numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(100);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int cursor = -1;

            @Override
            public boolean hasNext() {
                if (cursor + 1 < numbers.length) {
                    return true;
                }
                return false;
            }

            @Override
            public Integer next() {
                cursor++;
                return numbers[cursor];
            }

        };
    }
}

public class Main {
    public static void main(String[] args) {
        RandomNumbers rn = new RandomNumbers(10);
        System.out.println(rn);
        for (int num : rn) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
