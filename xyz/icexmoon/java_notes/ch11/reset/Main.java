package ch11.reset;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String str = "jdwp=transport=dt_socket,server=n,suspend=y,address=localhost:9515";
        Pattern p = Pattern.compile("\\w+=\\w+");
        Matcher m = p.matcher(str);
        String result = "";
        result = m.replaceAll("key=value");
        System.out.println(result);
        m.reset("hello=world");
        result = m.replaceAll("key=value");
        System.out.println(result);
    }
}
// key=value=dt_socket,key=value,key=value,key=value:9515
// key=value