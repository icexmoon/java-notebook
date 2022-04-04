package ch17.nio2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {
    public static void main(String[] args) throws IOException {
        final String CURRENT_DIR = "./xyz/icexmoon/java_notes/ch17/nio2/";
        final String SOURCE_FILE = CURRENT_DIR + "Main.java";
        final String DES_FILE = CURRENT_DIR + "data.out";
        copyFile(SOURCE_FILE, DES_FILE);
    }

    private static void copyFile(String source, String des) throws IOException {
        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(des);
        FileChannel fcIn = fis.getChannel();
        FileChannel fcOut = fos.getChannel();
        ByteBuffer bb = ByteBuffer.allocate(1024);
        do {
            if (fcIn.read(bb) == -1) {
                break;
            }
            bb.flip();
            fcOut.write(bb);
            bb.clear();
        } while (true);
        fcIn.close();
        fcOut.close();
        fis.close();
        fos.close();
    }
}
