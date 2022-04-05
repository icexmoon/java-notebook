package ch17.file_map;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class Main {
    public static void main(String[] args) throws IOException {
        final String CURRENT_DIR = "./xyz/icexmoon/java_notes/ch17/file_map/";
        final String FILE = CURRENT_DIR + "data.out";
        final int SIZE = 0x8FFFFFF;// 128MB
        RandomAccessFile raf = new RandomAccessFile(FILE, "rw");
        FileChannel fc = raf.getChannel();
        MappedByteBuffer mbb = fc.map(MapMode.READ_WRITE, 0, SIZE);
        for (int i = 0; i < SIZE; i++) {
            mbb.put((byte) 'x');
        }
        for (int i = SIZE / 2; i < SIZE / 2 + 6; i++) {
            System.out.print((char) mbb.get(i) + " ");
        }
        System.out.println();
        fc.close();
        raf.close();
    }
}
// x x x x x x 