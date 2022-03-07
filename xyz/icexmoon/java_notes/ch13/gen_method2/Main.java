package ch13.gen_method2;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = getList();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        System.out.println(numbers);
    }

    private static <T> List<T> getList() {
        return new ArrayList<T>();
    }
}
// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]