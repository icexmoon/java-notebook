package ch16.sort;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import ch15.test2.RandomGenerator;
import ch16.generator.ListFiller;
import util.Fmt;

public class Main {
    private static Random random = new Random();

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        ListFiller.fill(list, new RandomGenerator.IntGenerator(), 10);
        test(list);
    }

    private static <T extends Comparable<? super T>> void test(List<T> list) {
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        T key = list.get(random.nextInt(list.size()));
        int index = Collections.binarySearch(list, key);
        Fmt.printf("find %s in list, index is %d", key, index);
    }
}
// [20, 22, 90, 95, 56, 83, 16, 7, 50, 18]
// [7, 16, 18, 20, 22, 50, 56, 83, 90, 95]
// find 50 in list, index is 5