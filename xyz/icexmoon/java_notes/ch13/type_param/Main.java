package ch13.type_param;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        System.out.println(list1.getClass() == list2.getClass());
        System.out.println(list1.getClass() == ArrayList.class);
    }
}
// true
// true