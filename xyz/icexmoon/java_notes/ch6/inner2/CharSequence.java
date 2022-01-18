package ch6.inner2;

import java.util.Arrays;

import ch6.inner2.IOInterface.ReaderWriter;

public class CharSequence implements ReaderWriter {
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
