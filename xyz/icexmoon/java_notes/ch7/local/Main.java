package ch7.local;

import java.util.Random;

interface Printable {
    void print();
}

public class Main {
    private static Printable getPrinter1() {
        return new Printable() {
            private int num;
            {
                num = random.nextInt(100);
            }
            private static Random random = new Random();

            @Override
            public void print() {
                System.out.println("non-name class's num:" + num);
            }

        };
    }

    private static Printable getPrinter2() {
        class NumberPrinter implements Printable {
            private int num;
            private static Random random = new Random();

            public NumberPrinter() {
                num = random.nextInt(100);
            }

            @Override
            public void print() {
                System.out.println("local inner class's num:" + num);
            }

        }
        return new NumberPrinter();
    }

    public static void main(String[] args) {
        Printable p1 = getPrinter1();
        Printable p2 = getPrinter2();
        p1.print();
        p2.print();
        // non-name class's num:87
        // local inner class's num:93
    }
}
