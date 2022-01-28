package ch11.hex_reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    private static byte[] readFile(String fname) throws IOException {
        InputStream is = new FileInputStream(fname);
        try {
            byte[] bytesCache = new byte[20];
            int size = is.available();
            byte[] allBytes = new byte[size];
            if (size == 0) {
                return allBytes;
            }
            int cursor = 0;
            int readNum = 0;
            do {
                readNum = is.read(bytesCache);
                if (readNum > 0) {
                    for (int i = 0; i < readNum; i++) {
                        allBytes[cursor] = bytesCache[i];
                        cursor++;
                    }
                }
            } while (readNum != -1);
            return allBytes;
        } finally {
            is.close();
        }
    }

    public static void main(String[] args) {
        String fname = "D:\\workspace\\java\\java-notebook\\xyz\\icexmoon\\java_notes\\ch11\\conn\\Main.class";
        try {
            byte[] bytes = readFile(fname);
            int index = 0;
            System.out.format("%05X:  ", index);
            for (byte b : bytes) {
                index++;
                System.out.format("%02X ", b);
                if (index % 16 == 0) {
                    System.out.println();
                    System.out.format("%05X:  ", index);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
// 00000:  CA FE BA BE 00 00 00 3C 00 36 0A 00 02 00 03 07 
// 00010:  00 04 0C 00 05 00 06 01 00 10 6A 61 76 61 2F 6C
// 00020:  61 6E 67 2F 4F 62 6A 65 63 74 01 00 06 3C 69 6E
// 00030:  69 74 3E 01 00 03 28 29 56 08 00 08 01 00 06 68
// 00040:  65 6C 6C 6F 77 08 00 0A 01 00 01 20 08 00 0C 01 
// 00050:  00 05 77 6F 72 6C 64 08 00 0E 01 00 01 21 12 00
// 00060:  00 00 10 0C 00 11 00 12 01 00 17 6D 61 6B 65 43
// ...