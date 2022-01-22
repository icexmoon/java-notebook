package ch9.set3;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Collections;

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
        Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                int a = o1.intValue();
                int b = o2.intValue();
                if (a < b) {
                    return 1;
                } else if (a == b) {
                    return 0;
                } else {
                    return -1;
                }
            }

        });
        fillSet(set);
        printSet(set);
        // 83 79 73 72 67 58 29 17 5 
        set = new TreeSet<>(Collections.reverseOrder());
        fillSet(set);
        printSet(set);
        // 72 69 67 59 55 42 23 21 20 12
    }
}
