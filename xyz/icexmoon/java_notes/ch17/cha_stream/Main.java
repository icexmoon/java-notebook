package ch17.cha_stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final String CURRENT_DIR = "./xyz/icexmoon/java_notes/ch17/cha_stream/";
        final String FILE_NAME = "char.out";
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(CURRENT_DIR + FILE_NAME)));
        bw.write("Hellow world!\n");
        bw.write("How are you!\n");
        bw.write("Bye~~\n");
        bw.close();
        BufferedReader br = new BufferedReader(new FileReader(CURRENT_DIR + FILE_NAME));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
// Hellow world!
// How are you!
// Bye~~