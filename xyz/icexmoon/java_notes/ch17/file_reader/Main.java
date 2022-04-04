package ch17.file_reader;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final String CURRENT_DIR = "./xyz/icexmoon/java_notes/ch17/file_reader/";
        final String FILE_NAME = "Main.java";
        final String FILE_PATH = CURRENT_DIR + FILE_NAME;
        FileReader fr = new FileReader(FILE_PATH);
        do {
            char[] buff = new char[255];
            int num = fr.read(buff);
            if (num == -1) {
                break;
            }
            for (int i = 0; i < num; i++) {
                System.out.print(buff[i]);
            }
        } while (true);
        fr.close();
    }
}
