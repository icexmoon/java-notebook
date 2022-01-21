package ch8.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Main {
    private static Random random = new Random();

    private static Collection<Integer> getRandomNumbers(int times) {
        Collection<Integer> collection = new ArrayList<Integer>();
        for (int i = 0; i < times; i++) {
            collection.add(random.nextInt(100));
        }
        return collection;
    }

    public static void main(String[] args) {
        Collection<Integer> numbers = new ArrayList<Integer>();
        numbers.add(100);
        System.out.println(numbers);
        Collection<Integer> numbers2 = getRandomNumbers(3);
        System.out.println(numbers2);
        numbers.addAll(numbers2);
        System.out.println(numbers);
        System.out.println(numbers.contains(100));
        System.out.println(numbers.containsAll(numbers2));
        numbers.remove(100);
        System.out.println(numbers);
        numbers.removeAll(numbers2);
        System.out.println(numbers);
        System.out.println(numbers.add(99));
        System.out.println(numbers);
        numbers.clear();
        System.out.println(numbers);
        // [100]
        // [60, 95, 44]
        // [100, 60, 95, 44]
        // true
        // true
        // [60, 95, 44]
        // []
        // true
        // [99]
        // []
    }
}
