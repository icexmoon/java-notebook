package ch13.multi_param;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List list = getList(1, 2, 3, 4, 5);
        System.out.println(list);
    }

    private static <T> List<T> getList(T... items) {
        List<T> list = new ArrayList<>();
        for (T t : items) {
            list.add(t);
        }
        return list;
    }
}
// [1, 2, 3, 4, 5]
