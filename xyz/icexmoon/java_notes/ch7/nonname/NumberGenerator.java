package ch7.nonname;

import java.util.Random;

public class NumberGenerator {
    private static Random random = new Random();

    public Printable getPrinter(int printTimes) {
        if (printTimes <= 0) {
            return null;
        }
        return new Printable() {

            @Override
            public void print() {
                for (int i = 0; i < printTimes; i++) {
                    System.out.print(getNumber() + " ");
                }
                System.out.println();
            }

        };
    }

    public int getNumber() {
        return random.nextInt(100);
    }

}