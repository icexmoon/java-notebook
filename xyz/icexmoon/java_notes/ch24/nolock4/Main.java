package ch24.nolock4;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (Integer integer : list) {
            System.out.print(integer+" ");
            if(integer.equals(3)){
                list.remove(integer);
            }
        }
        System.out.println();
        System.out.println(list);
    }
}
// 0 1 2 3 4 5 6 7 8 9 
// [0, 1, 2, 4, 5, 6, 7, 8, 9]