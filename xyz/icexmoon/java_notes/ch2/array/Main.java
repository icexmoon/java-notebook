package ch2.array;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[random.nextInt(9) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        // [35, 42, 54, 77, 74, 31, 7, 74]
    }
}
