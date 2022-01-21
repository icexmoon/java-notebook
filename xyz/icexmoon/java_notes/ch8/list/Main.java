package ch8.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        list.add(random.nextInt(100));
        System.out.println(list);
        Integer[] numbers = new Integer[] { 1, 2, 3, 4, 5, 6, 7 };
        list.addAll(Arrays.asList(numbers));
        System.out.println(list);
        System.out.println(list.indexOf(3));
        list.add(3, 99);
        System.out.println(list);
        list.addAll(3, Arrays.asList(new Integer[] { 99, 1, 99 }));
        System.out.println(list);
        System.out.println(list.lastIndexOf(99));
        list.remove(new Integer(99));
        System.out.println(list);
        list.remove(4);
        System.out.println(list);
        // [91]
        // [91, 1, 2, 3, 4, 5, 6, 7]
        // 3
        // [91, 1, 2, 99, 3, 4, 5, 6, 7]
        // [91, 1, 2, 99, 1, 99, 99, 3, 4, 5, 6, 7]
        // 6
        // [91, 1, 2, 1, 99, 99, 3, 4, 5, 6, 7]
        // [91, 1, 2, 1, 99, 3, 4, 5, 6, 7]
    }
}
