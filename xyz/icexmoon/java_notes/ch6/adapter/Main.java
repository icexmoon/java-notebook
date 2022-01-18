package ch6.adapter;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

class NumberGenerator {
    private static Random random = new Random();

    public int getNumber() {
        return random.nextInt(100);
    }
}

class NGReadableAdapter implements Readable {
    private int times;
    private NumberGenerator ng;

    public NGReadableAdapter(NumberGenerator ng, int readTimes) {
        this.ng = ng;
        if (readTimes < 0) {
            throw new Error();
        }
        this.times = readTimes;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (times > 0) {
            String strNum = Integer.toString(ng.getNumber());
            cb.append(strNum + " ");
            times--;
            return strNum.length() + 1;
        }
        return -1;
    }

}

public class Main {
    public static void main(String[] args) {
        NumberGenerator ng = new NumberGenerator();
        Scanner scanner = new Scanner(new NGReadableAdapter(ng, 10));
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}
