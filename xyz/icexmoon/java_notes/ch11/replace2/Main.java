package ch11.replace2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String str = "jdwp=transport=dt_socket,server=n,suspend=y,address=localhost:9515";
        Pattern p = Pattern.compile("(\\w+)=(\\w+(:\\d+)?)");
        Matcher m = p.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String key = m.group(1);
            String value = m.group(2);
            String replacement = m.group();
            if (key.equals("address")) {
                replacement = "address=127.0.0.1:8888";
            } else if (key.equals("server")) {
                replacement = "server=y";
            } else {
                ;
            }
            m.appendReplacement(sb, replacement);
        }
        m.appendTail(sb);
        System.out.println(str);
        System.out.println(sb.toString());
    }
}
// jdwp=transport=dt_socket,server=n,suspend=y,address=localhost:9515
// jdwp=transport=dt_socket,server=y,suspend=y,address=127.0.0.1:8888