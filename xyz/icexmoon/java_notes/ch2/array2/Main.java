package ch2.array2;

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
        int[] arr2 = arr;
        arr2[0] = 101;
        System.out.println(Arrays.toString(arr));
        // [47, 7, 32, 9, 70, 45, 39]
        // [101, 7, 32, 9, 70, 45, 39]
    }
}
