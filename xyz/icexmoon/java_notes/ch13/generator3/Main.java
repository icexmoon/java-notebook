package ch13.generator3;

import java.util.Iterator;

class FibonacciAdapter implements Iterable<Integer> {
    private FibonacciGenerator fg;
    private int size;

    public FibonacciAdapter(FibonacciGenerator fg, int size) {
        this.fg = fg;
        this.size = size;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int nowSize = size;

            @Override
            public boolean hasNext() {
                return nowSize > 0;
            }

            @Override
            public Integer next() {
                if (nowSize <= 0) {
                    return -1;
                }
                int result = fg.next();
                nowSize--;
                return result;
            }

        };
    }

}

public class Main {
    public static void main(String[] args) {
        FibonacciGenerator fg = new FibonacciGenerator();
        for (int number : new FibonacciAdapter(fg, 10)) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
// 1 1 2 3 5 8 13 21 34 55