package ch15.search;

import java.util.Arrays;
import java.util.Random;

import ch15.test2.ArrayFiller;
import ch15.test2.RandomGenerator;

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[6];
        ArrayFiller.fill(numbers, new RandomGenerator.IntGenerator());
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        find(numbers);
    }

    private static int find(Integer[] nums) {
        Random rand = new Random();
        Integer target = rand.nextInt(100);
        int index = Arrays.binarySearch(nums, target);
        if (index > 0) {
            System.out.println(target + " is matched, index is " + index);
            return index;
        } else {
            return find(nums);
        }
    }
}
// [12, 14, 24, 41, 63, 83]
// 63 is matched, index is 4
