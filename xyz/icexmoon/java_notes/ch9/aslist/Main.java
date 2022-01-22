package ch9.aslist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] array = new Integer[] { 1, 2, 3, 4, 5, 6 };
        List<Integer> list = Arrays.asList(array);
        Collections.shuffle(list);
        System.out.println(list);
        System.out.println(Arrays.toString(array));
        // [2, 4, 3, 1, 6, 5]
        // [2, 4, 3, 1, 6, 5]
        array = new Integer[] { 1, 2, 3, 4, 5, 6 };
        list = new ArrayList<>(Arrays.asList(array));
        Collections.shuffle(list);
        System.out.println(list);
        System.out.println(Arrays.toString(array));
        // [6, 2, 3, 5, 1, 4]
        // [1, 2, 3, 4, 5, 6]

    }
}
