package ch11.string10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        String fname = "D:\\workspace\\java\\java-notebook\\xyz\\icexmoon\\java_notes\\ch11\\string9\\Main.java";
        BufferedReader bf = new BufferedReader(new FileReader(fname));
        StringBuffer sb = new StringBuffer();
        try {
            String line = null;
            while ((line = bf.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } finally {
            bf.close();
        }
        String regex = "(?m)^import\\s+(((\\w+(\\.)?))+);$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
// java.io.BufferedReader
// java.io.FileReader
// java.io.IOException
// java.util.regex.Matcher
// java.util.regex.Pattern