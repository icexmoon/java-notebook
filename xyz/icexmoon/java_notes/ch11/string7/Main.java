package ch11.string7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Matcher matcher = Pattern.compile("\\d+").matcher("12345");
        System.out.println(matcher.matches());
    }
}
// true