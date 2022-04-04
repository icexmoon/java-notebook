package ch17.nio3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class Main {
    public static void main(String[] args) throws IOException {
        final String CURRENT_DIR = "./xyz/icexmoon/java_notes/ch17/nio3/";
        final String SOURCE_FILE = CURRENT_DIR + "Main.java";
        final String DES_FILE = CURRENT_DIR + "data.out";
        copyFile(SOURCE_FILE, DES_FILE);
    }

    private static void copyFile(String source, String des) throws IOException {
        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(des);
        FileChannel fcIn = fis.getChannel();
        FileChannel fcOut = fos.getChannel();
        // fcOut.transferFrom(fcIn, 0, fcIn.size());
        fcIn.transferTo(0, fcIn.size(), fcOut);
        fcIn.close();
        fcOut.close();
        fis.close();
        fos.close();
    }
}
