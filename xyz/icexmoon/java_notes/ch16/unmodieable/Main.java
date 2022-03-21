package ch16.unmodieable;

import java.util.ArrayList;
import java.util.List;

import ch15.test2.Generator;
import ch15.test2.RandomGenerator;
import ch16.generator.ListFiller;

class RandomIntList {
    private static List<Integer> list = new ArrayList<>();
    private static Generator<Integer> gen = new RandomGenerator.IntGenerator();

    public static List<Integer> get(int num) {
        if (list.size() == num) {
            return list;
        }
        list = new ArrayList<>();
        ListFiller.fill(list, gen, num);
        return list;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Integer> list = RandomIntList.get(10);
        System.out.println(list);
        list.set(0, -1);
        System.out.println(RandomIntList.get(10));
    }
}
// [71, 34, 48, 6, 85, 51, 10, 44, 54, 97]
// [-1, 34, 48, 6, 85, 51, 10, 44, 54, 97]