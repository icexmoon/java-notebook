package ch13.gen_method4;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = fillList(Main.<Integer>getList(), 10);
        System.out.println(numbers);
    }

    private static List<Integer> fillList(List<Integer> numbers, int size) {
        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    private static <T> List<T> getList() {
        return new ArrayList<T>();
    }
}
// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]