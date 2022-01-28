package ch11.string8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String[] strs = new String[] { "12345abcde", "12345", "+12345", "abc123" };
        for (String str : strs) {
            Matcher matcher = Pattern.compile("\\d+").matcher(str);
            System.out.println(matcher.lookingAt());
        }
    }
}
// true
// true
// false
// false