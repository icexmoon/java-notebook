package ch17.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {
    public static void main(String[] args) throws IOException {
        final String CURRENT_DIR = "./xyz/icexmoon/java_notes/ch17/nio/";
        final String FILE = CURRENT_DIR + "data.out";
        FileOutputStream fos = new FileOutputStream(FILE);
        FileChannel fc = fos.getChannel();
        fc.write(ByteBuffer.wrap("Hello world!\n".getBytes()));
        fc.close();
        fos.close();
        RandomAccessFile raf = new RandomAccessFile(FILE, "rw");
        fc = raf.getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("How are you.\n".getBytes()));
        fc.close();
        raf.close();
        FileInputStream fis = new FileInputStream(FILE);
        fc = fis.getChannel();
        ByteBuffer bf = ByteBuffer.allocate(1024);
        fc.read(bf);
        bf.flip();
        while (bf.hasRemaining()) {
            System.out.print((char) bf.get());
        }
        fc.close();
        fis.close();
    }
}
// Hello world!
// How are you.