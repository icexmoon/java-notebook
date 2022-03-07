package ch13.generator3;
import ch13.generator.Generator;

public class FibonacciGenerator implements Generator<Integer> {
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
