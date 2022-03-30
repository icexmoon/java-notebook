package ch17.file4;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import util.Fmt;

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
            System.out.println("================================");
            printFileInfo(path);
        }
    }

    private static void printFileInfo(File file) {
        Fmt.printf("name:%s\n", file.getName());
        boolean isFile = file.isFile();
        String type = isFile ? "file" : "dir";
        Fmt.printf("type:%s\n", type);
        Fmt.printf("abs path:%s\n", file.getAbsolutePath());
        try {
            Fmt.printf("canonical path:%s\n", file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Fmt.printf("parent:%s\n", file.getParentFile().getAbsolutePath());
        long lastModified = file.lastModified();
        Fmt.printf("last modified:%s\n", date2Str(lastModified));
        boolean canRead = file.canRead();
        Fmt.printf("can read:%s\n", canRead);
    }

    private static String date2Str(long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(new Date(date));
    }
}
// ================================
// name:exception.log
// type:file
// abs path:D:\workspace\java\java-notebook\.\exception.log
// canonical path:D:\workspace\java\java-notebook\exception.log
// parent:D:\workspace\java\java-notebook\.
// last modified:2022-01-24 03:55:55
// can read:true
// ================================
// name:exp.log
// type:file
// abs path:D:\workspace\java\java-notebook\.\exp.log
// canonical path:D:\workspace\java\java-notebook\exp.log
// parent:D:\workspace\java\java-notebook\.
// last modified:2022-01-24 04:30:34
// can read:true