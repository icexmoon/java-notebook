package ch17.encode3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) throws IOException {
        final String CURRENT_DIR = "./xyz/icexmoon/java_notes/ch17/encode3/";
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
        final String charsetName = System.getProperty("file.encoding");
        Charset charset =  Charset.forName(charsetName);
        System.out.println(charset.decode(bb));
        fis.close();
        inChannel.close();
    }
}
// Hello world!