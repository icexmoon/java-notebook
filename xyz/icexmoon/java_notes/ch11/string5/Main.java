package ch11.string5;

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
        }
    }
}
// key:jdwp, value:transport
// key:server, value:n
// key:suspend, value:y
// key:address, value:localhost:8662