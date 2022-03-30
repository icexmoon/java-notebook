package ch17.file3;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        File file = new File(".");
        final String regex = ".*\\.log";
        File[] paths = file.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }

        });
        for (File path : paths) {
            System.out.println(path);
        }
    }
}
// .\exception.log
// .\exp.log