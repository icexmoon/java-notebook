package ch11.split2;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String str = "jdwp=transport=dt_socket,server=n,suspend=y,address=localhost:9515";
        Pattern p = Pattern.compile("[=:,]");
        String[] result = p.split(str, 3);
        System.out.println(Arrays.toString(result));
    }
}
// [jdwp, transport, dt_socket,server=n,suspend=y,address=localhost:9515]