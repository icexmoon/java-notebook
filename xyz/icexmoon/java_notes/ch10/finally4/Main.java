package ch10.finally4;

import java.util.Random;

public class Main {
    private static void testFinally(int i) {
        try {
            if (i < 5) {
                System.out.println("i<5");
                return;
            } else {
                System.out.println("i>=5");
                return;
            }
        } finally {
            System.out.println("finally block is executed.");
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        testFinally(random.nextInt(10));
        // i>=5
        // finally block is executed.
    }
}
