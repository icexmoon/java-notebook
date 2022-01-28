package ch11.string6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.Fmt;

public class Main {

    public static void main(String[] args) {
        String str = "-agentlib:jdwp=transport=dt_socket,server=n,suspend=y,address=localhost:8662";
        Pattern pattern = Pattern.compile("(\\w+)=(\\w+(:\\d+)?)");
        Matcher machter = pattern.matcher(str);
        while (machter.find()) {
            String key = machter.group(1);
            String value = machter.group(2);
            Fmt.printf("key:%s, value:%s\n", key, value);
            System.out.println(str.substring(machter.start(), machter.end()));
        }
    }
}
// key:jdwp, value:transport
// jdwp=transport
// key:server, value:n
// server=n
// key:suspend, value:y
// suspend=y
// key:address, value:localhost:8662
// address=localhost:8662