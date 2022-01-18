package ch6.inner;

import java.util.Random;

interface IOInterface {
    interface Reader {
        int read(char[] content);
    }

    interface Writer {
        int write(char[] content);
    }

    interface ReaderWriter extends Reader, Writer {
    }
}

public class Main {
    private static Random random = new Random();

    private static char[] getRandomChars() {
        char[] chars = new char[random.nextInt(10) + 1];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (random.nextInt(32) + 97);
        }
        return chars;
    }

    public static void main(String[] args) {
        CharSequence cs = new CharSequence(new char[10]);
        char[] chars1 = getRandomChars();
        cs.write(chars1);
        System.out.println(chars1);
        System.out.println(cs);
        char[] chars2 = new char[5];
        cs.read(chars2);
        System.out.println(chars2);
        // pyvgtqalyy
        // [p, y, v, g, t, q, a, l, y, y]
        // pyvgt
    }
}
