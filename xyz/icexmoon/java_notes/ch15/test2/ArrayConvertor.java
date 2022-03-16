package ch15.test2;

import java.util.Arrays;

public class ArrayConvertor {
    public static int[] convert(Integer[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public static char[] convert(Character[] arr) {
        char[] newArr = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] numbers = convert(ArrayFiller.fill(new RandomGenerator.IntGenerator(), Integer.class, 6));
        System.out.println(Arrays.toString(numbers));
    }

}
// [46, 45, 15, 3, 47, 95]