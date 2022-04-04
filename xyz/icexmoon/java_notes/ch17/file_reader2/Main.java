package ch17.file_reader2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        final String CURRENT_DIR = "./xyz/icexmoon/java_notes/ch17/file_reader2/";
        final String FILE_NAME = "Main.java";
        final String FILE_PATH = CURRENT_DIR + FILE_NAME;
        InputStreamReader isr = new InputStreamReader(new FileInputStream(FILE_PATH), "UTF8");
        do {
            char[] buff = new char[255];
            int num = isr.read(buff);
            if (num == -1) {
                break;
            }
            for (int i = 0; i < num; i++) {
                System.out.print(buff[i]);
            }
        } while (true);
        isr.close();
    }
}
