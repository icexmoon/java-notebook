package ch7.nonname3;

import java.util.Random;

public class NumberGenerator {
    private static Random random = new Random();

    public Printable getPrinter(int printTimes) {
        if (printTimes <= 0) {
            return null;
        }
        printTimes = random.nextInt(10);
        return new Printable() {

            @Override
            public void print() {
                // Local variable printTimes defined in an enclosing scope must be final or effectively final
                // for (int i = 0; i < printTimes; i++) {
                //     System.out.print(getNumber() + " ");
                // }
                System.out.println();
            }

        };
    }

    public int getNumber() {
        return random.nextInt(100);
    }

}