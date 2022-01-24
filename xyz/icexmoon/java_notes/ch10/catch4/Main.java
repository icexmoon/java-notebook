package ch10.catch4;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

class MyException extends Exception {
}

public class Main {
    private static void g() throws MyException {
        throw new MyException();
    }

    private static void f() throws MyException {
        g();
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            Logger logger = Logger.getLogger("xyz.icexmoon.java-notes.ch10.ctch4.Main");
            FileHandler fh;
            try {
                String fname = "D:\\workspace\\java\\java-notebook\\xyz\\icexmoon\\java_notes\\ch10\\catch4\\exp.log";
                fh = new FileHandler(fname);
                logger.addHandler(fh);
                logger.severe(sw.toString());
            } catch (SecurityException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
