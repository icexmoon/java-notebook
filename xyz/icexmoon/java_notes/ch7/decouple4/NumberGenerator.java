package ch7.decouple4;

import java.util.Random;

public class NumberGenerator {
    private static Random random = new Random();

    public Printable getPrinter(int printTimes) {
        return new NGPrintAdapter(printTimes);
    }

    public int getNumber() {
        return random.nextInt(100);
    }

    private class NGPrintAdapter implements Printable {
        private int printTimes;

        public NGPrintAdapter(int printTimes) {
            if (printTimes < 0) {
                throw new Error();
            }
            this.printTimes = printTimes;
        }

        @Override
        public void print() {
            for (int i = 0; i < printTimes; i++) {
                System.out.print(getNumber() + " ");
            }
            System.out.println();
        }

    }
}