package util;

import java.util.Formatter;

public class Fmt {
    public static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    public static String sprintf(String format, Object... args){
        return String.format(format, args);
    }

    public static void fprintf(Appendable appendable, String format, Object... args){
        Formatter formatter = new Formatter(appendable);
        formatter.format(format, args);
        formatter.close();
    }
}
