package ch9.map3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> counter = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int num = random.nextInt(10) + 1;
            if (!counter.containsKey(num)) {
                counter.put(num, 0);
            }
            int oldTimes = counter.get(num);
            counter.put(num, oldTimes + 1);
        }
        System.out.println(counter);
        // {1=12, 2=11, 3=11, 4=8, 5=6, 6=8, 7=8, 8=13, 9=5, 10=18}
    }
}
