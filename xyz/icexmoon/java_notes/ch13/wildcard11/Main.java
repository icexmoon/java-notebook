package ch13.wildcard11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class WildcardChecker {
    private List list1;
    private List<?> list2;
    private List<? extends Object> list3;

    public void assign(List list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }

    public void assign2(List<?> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }

    public void assign3(List<? extends Object> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }
}

public class Main {
    public static void main(String[] args) {
        WildcardChecker wc = new WildcardChecker();
        wc.assign(new ArrayList<>());
        wc.assign2(new ArrayList<>());
        wc.assign(new ArrayList<>());
        wc.assign(new ArrayList<String>());
        wc.assign(new ArrayList<String>());
        wc.assign(new ArrayList<String>());
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
