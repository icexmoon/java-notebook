package ch17.encode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {
    public static void main(String[] args) throws IOException {
        final String CURRENT_DIR = "./xyz/icexmoon/java_notes/ch17/encode/";
        final String FILE = CURRENT_DIR + "data.out";
        FileOutputStream fos = new FileOutputStream(FILE);
        FileChannel outChannel = fos.getChannel();
        outChannel.write(ByteBuffer.wrap("Hello world!".getBytes()));
        fos.close();
        outChannel.close();
        FileInputStream fis = new FileInputStream(FILE);
        FileChannel inChannel = fis.getChannel();
        ByteBuffer bb = ByteBuffer.allocate(255);
        inChannel.read(bb);
        bb.flip();
        System.out.println(bb.asCharBuffer());
        fis.close();
        inChannel.close();
    }
}
// ?汬漠睯牬搡
