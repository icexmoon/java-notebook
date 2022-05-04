package ch24.nolock3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.print(integer + " ");
            if (integer.equals(3)) {
                iterator.remove();
            }
        }
        System.out.println();
        System.out.println(list);
    }
}
// 0 1 2 3 4 5 6 7 8 9 
// [0, 1, 2, 4, 5, 6, 7, 8, 9]