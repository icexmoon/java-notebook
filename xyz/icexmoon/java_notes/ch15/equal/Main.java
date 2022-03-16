package ch15.equal;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 1, 2, 3, 4, 5 };
        boolean result = Arrays.equals(arr1, arr2);
        System.out.println(result);
    }
}
