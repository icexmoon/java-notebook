package ch24.nolock2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (Integer integer : list) {
            System.out.println(integer);
            if(integer.equals(3)){
                list.remove(integer);
            }
        }
    }
}
// 0
// 1
// 2
// 3
// Exception in thread "main" java.util.ConcurrentModificationException
//         at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1013)
//         at java.base/java.util.ArrayList$Itr.next(ArrayList.java:967)
//         at ch24.nolock.Main.main(Main.java:12)