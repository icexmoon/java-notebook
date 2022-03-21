package ch16.synchronize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list = Collections.synchronizedList(list);
        list.addAll(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(list);
        Map<Integer, String> map = new HashMap<>();
        map = Collections.synchronizedMap(map);
        map.put(1, "hello");
        map.put(2, "world");
        System.out.println(map);
    }

}
// [1, 2, 3, 4, 5]
// {1=hello, 2=world}