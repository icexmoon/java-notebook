package ch13.wildcard12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List list = numbers;
        list.add(Integer.valueOf(6));
        System.out.println(list.get(0));
        List<?> list2 = numbers;
        // list2.add(Integer.valueOf("6"));
        // The method add(capture#13-of ?) in the type List<capture#13-of ?> is not
        // applicable for the arguments (Integer)
        System.out.println(list.get(0));
    }
}
