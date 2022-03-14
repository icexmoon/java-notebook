package ch14.base_type;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
// 1 2 3 4 5 6 7 8 9 10 
