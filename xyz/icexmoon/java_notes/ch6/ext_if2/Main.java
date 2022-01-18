package ch6.ext_if2;

import java.util.Arrays;
import java.util.Random;

interface Writer {
    int write(char[] content);
}

interface Reader {
    int read(char[] content);
}

interface ReaderWriter extends Reader, Writer {
}

class CharSequence implements ReaderWriter {
    private char[] chars;

    public CharSequence(char[] chars) {
        this.chars = chars;
    }

    @Override
    public int write(char[] content) {
        if (content.length == 0) {
            return 0;
        }
        int counter = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i >= content.length) {
                break;
            }
            chars[i] = content[i];
            counter++;
        }
        return counter;
    }

    @Override
    public int read(char[] content) {
        int counter = 0;
        for (int i = 0; i < content.length; i++) {
            if (i >= chars.length) {
                break;
            }
            content[i] = chars[i];
            counter++;
        }
        return counter;
    }

    @Override
    public String toString() {
        return Arrays.toString(chars);
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
