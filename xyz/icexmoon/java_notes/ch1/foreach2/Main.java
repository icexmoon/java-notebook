package ch1.foreach2;

import java.util.stream.IntStream;

class Main {

    public static void main(String[] args) {
        int[] numbers = IntStream.range(1, 11).toArray();
        for (int i : numbers) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
// 1 2 3 4 5 6 7 8 9 10