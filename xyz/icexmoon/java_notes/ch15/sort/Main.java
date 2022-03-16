
package ch15.sort;

import java.util.Arrays;

import ch15.test2.ArrayConvertor;
import ch15.test2.ArrayFiller;
import ch15.test2.RandomGenerator;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        ArrayFiller.fill(arr, new RandomGenerator.IntGenerator());
        int[] arr2 = ArrayConvertor.convert(arr);
        System.out.println(Arrays.toString(arr2));
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
// [34, 55, 72, 29, 10, 53, 17, 88, 57, 11]
// [10, 11, 17, 29, 34, 53, 55, 57, 72, 88]