package ch17.file_lock2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.FileChannel.MapMode;

class LockAndModify extends Thread {
    ByteBuffer bb;
    FileChannel fc;
    int start;
    int length;

    public LockAndModify(ByteBuffer bb, int start, int length, FileChannel fc) {
        this.bb = bb.slice(start, length);
        this.fc = fc;
        this.start = start;
        this.length = length;
    }

    @Override
    public void run() {
        super.run();
        try {
            FileLock fl = fc.lock(start, length, false);
            try {
                while (bb.position() < bb.limit() - 1) {
                    byte b1 = bb.get();
                    bb.put((byte) (b1 + 1));
                }
            } finally {
                fl.release();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

class LockAndRead extends Thread {
    ByteBuffer bb;
    FileChannel fc;
    int start;
    int length;

    public LockAndRead(ByteBuffer bb, int start, int length, FileChannel fc) {
        this.bb = bb.slice(start, length);
        this.fc = fc;
        this.start = start;
        this.length = length;
    }

    @Override
    public void run() {
        super.run();
        try {
            FileLock fl = fc.lock(start, length, false);
            try {
                StringBuffer sb = new StringBuffer();
                while (bb.hasRemaining()) {
                    sb.append((char) bb.get());
                    sb.append(" ");
                }
                System.out.println(sb.toString());
            } finally {
                fl.release();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        final String CURRENT_DIR = "./xyz/icexmoon/java_notes/ch17/file_lock2/";
        final String FILE = CURRENT_DIR + "data.out";
        final int SIZE = 0x8FFFFFF;
        RandomAccessFile raf = new RandomAccessFile(FILE, "rw");
        FileChannel fc = raf.getChannel();
        MappedByteBuffer mbb = fc.map(MapMode.READ_WRITE, 0, SIZE);
        for (int i = 0; i < SIZE; i++) {
            mbb.put((byte) 'x');
        }
        new LockAndModify(mbb, SIZE / 4, 10, fc).start();
        new LockAndModify(mbb, SIZE / 2, 10, fc).start();
        new LockAndRead(mbb, SIZE / 4, 10, fc).start();
        new LockAndRead(mbb, SIZE / 2, 10, fc).start();
        // fc.close();
        // raf.close();
    }
}
// x y x y x y x y x y 
// x y x y x y x y x y