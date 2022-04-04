package ch17.print_writer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        final String CURRENT_DIR = "./xyz/icexmoon/java_notes/ch17/print_writer/";
        final String SOURCE_FILE = CURRENT_DIR + "Main.java";
        final String DES_FILE = CURRENT_DIR + "out.data";
        BufferedReader br = new BufferedReader(new FileReader(SOURCE_FILE));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(DES_FILE)));
        try {
            do {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                pw.println(line);
            } while (true);
        } finally {
            br.close();
            pw.close();
        }
    }
}
