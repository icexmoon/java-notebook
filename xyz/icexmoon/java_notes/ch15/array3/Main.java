package ch15.array3;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[rand.nextInt(10)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));
        arr = new int[] { 1, 2, 3 };
        // arr = {1,2,3};
        // Array constants can only be used in initializersJava(1610612944)
        int[] arr2 = { 1, 2, 3 };
    }
}
