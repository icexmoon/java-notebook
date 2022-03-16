
package ch15.sort2;

import java.util.Arrays;
import java.util.Collections;

import ch15.test2.ArrayConvertor;
import ch15.test2.ArrayFiller;
import ch15.test2.RandomGenerator;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        ArrayFiller.fill(arr, new RandomGenerator.IntGenerator());
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
    }
}
// [71, 7, 70, 18, 49, 52, 97, 58, 92, 41]
// [97, 92, 71, 70, 58, 52, 49, 41, 18, 7]