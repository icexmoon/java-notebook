package ch13.generator2;

import ch13.generator.Generator;

class FibonacciGenerator implements Generator<Integer> {
    private int index = 1;

    @Override
    public Integer next() {
        return fibonacci(index++);
    }

    private static int fibonacci(int index) {
        if (index <= 2) {
            return 1;
        }
        return fibonacci(index - 1) + fibonacci(index - 2);
    }

}

public class Main {
    public static void main(String[] args) {
        FibonacciGenerator fg = new FibonacciGenerator();
        for (int i = 0; i < 10; i++) {
            System.out.print(fg.next() + " ");
        }
        System.out.println();
    }
}
// 1 1 2 3 5 8 13 21 34 55 