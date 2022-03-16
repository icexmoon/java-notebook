package ch16.fill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(i);
        }
        System.out.println(nums);
        Collections.fill(nums, Integer.valueOf(99));
        System.out.println(nums);
    }
}
// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
// [99, 99, 99, 99, 99, 99, 99, 99, 99, 99]
