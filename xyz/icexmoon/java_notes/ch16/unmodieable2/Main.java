package ch16.unmodieable2;

import java.util.ArrayList;
import java.util.Collections;
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
        list = Collections.unmodifiableList(list);
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
// [22, 77, 38, 54, 16, 23, 23, 21, 65, 89]
// Exception in thread "main" java.lang.UnsupportedOperationException
// at
// java.base/java.util.Collections$UnmodifiableList.set(Collections.java:1323)
// at ch16.unmodieable2.Main.main(Main.java:30)