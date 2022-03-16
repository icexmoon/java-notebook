package ch15.array4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // test({1,2,3});
        test(new int[] { 1, 2, 3 });
    }

    private static void test(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
// [1, 2, 3]