package ch17.access_file;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
    public static void main(String[] args) throws IOException {
        final String CURRENT_DIR = "./xyz/icexmoon/java_notes/ch17/access_file/";
        final String FILE_NAME = "data.out";
        RandomAccessFile raf = new RandomAccessFile(CURRENT_DIR + FILE_NAME, "rw");
        for (int i = 0; i < 7; i++) {
            raf.writeInt(i);
        }
        raf.close();
        printFile(CURRENT_DIR + FILE_NAME);
        raf = new RandomAccessFile(CURRENT_DIR + FILE_NAME, "rw");
        raf.seek(3 * Integer.BYTES);
        raf.writeInt(999);
        raf.close();
        printFile(CURRENT_DIR + FILE_NAME);
    }

    private static void printFile(String fileName) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(fileName, "r");
        System.out.println("file contents:");
        do {
            int num = 0;
            try {
                num = raf.readInt();
            } catch (EOFException e) {
                break;
            }
            System.out.print(num + ", ");
        } while (true);
        raf.close();
        System.out.println();
    }
}
// file contents:
// 0, 1, 2, 3, 4, 5, 6,
// file contents:
// 0, 1, 2, 999, 4, 5, 6,