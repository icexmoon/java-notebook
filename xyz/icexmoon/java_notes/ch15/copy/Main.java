package ch15.copy;

import java.util.Arrays;

import ch15.test2.ArrayConvertor;
import ch15.test2.ArrayFiller;
import ch15.test2.CommonGenerator;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Arrays.fill(arr, 99);
        Integer[] arr2 = new Integer[5];
        ArrayFiller.fill(arr2, new CommonGenerator.IntGenerator());
        int[] arr3 = ArrayConvertor.convert(arr2);
        System.out.print("arr: ");
        System.out.println(Arrays.toString(arr));
        System.out.print("arr3: ");
        System.out.println(Arrays.toString(arr3));
        System.arraycopy(arr3, 0, arr, 0, arr3.length);
        System.out.print("arr:");
        System.out.println(Arrays.toString(arr));
    }
}
// arr: [99, 99, 99, 99, 99, 99, 99, 99, 99, 99]
// arr3: [0, 1, 2, 3, 4]
// arr:[0, 1, 2, 3, 4, 99, 99, 99, 99, 99]