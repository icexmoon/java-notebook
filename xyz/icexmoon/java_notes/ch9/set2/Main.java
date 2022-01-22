package ch9.set2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    private static Random random = new Random();

    private static void fillSet(Set<Integer> set) {
        for (int i = 0; i < 10; i++) {
            set.add(random.nextInt(100));
        }
    }

    private static void printSet(Set<Integer> set) {
        for (Integer integer : set) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new TreeSet<>();
        Set<Integer> set3 = new LinkedHashSet<>();
        fillSet(set1);
        printSet(set1);
        fillSet(set2);
        printSet(set2);
        set3.add(1);
        set3.add(2);
        set3.add(3);
        printSet(set3);
        // 96 64 33 97 82 2 8 41 42 79 
        // 38 47 49 53 55 57 66 70 92
        // 1 2 3
    }
}
