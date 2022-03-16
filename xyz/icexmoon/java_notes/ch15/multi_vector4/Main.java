package ch15.multi_vector4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final int SIZE = 5;
        int[][] arr = new int[SIZE][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];
        }
        System.out.println(Arrays.deepToString(arr));
    }
}
// [[0], [0, 0], [0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0, 0]]