package ch17.file_lock;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        final String CURRENT_DIR = "./xyz/icexmoon/java_notes/ch17/file_lock/";
        final String FILE = CURRENT_DIR + "Main.java";
        RandomAccessFile raf = new RandomAccessFile(FILE, "rw");
        FileChannel fc = raf.getChannel();
        FileLock fl = fc.tryLock();
        if (fl != null) {
            System.out.println("get file lock.");
            TimeUnit.SECONDS.sleep(1);
            fl.release();
            System.out.println("file lock is released.");
        }
        fc.close();
        raf.close();
    }
}
// get file lock.
// file lock is released.
