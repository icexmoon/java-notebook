package ch24.nolock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        new Thread(){
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.remove(5);
            };
        }.start();
        for (Integer integer : list) {
            System.out.println(integer);
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
// 0
// 1
// 2
// 3
// 4
// Exception in thread "main" java.util.ConcurrentModificationException
//         at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1013)
//         at java.base/java.util.ArrayList$Itr.next(ArrayList.java:967)
//         at ch24.nolock.Main.main(Main.java:23)