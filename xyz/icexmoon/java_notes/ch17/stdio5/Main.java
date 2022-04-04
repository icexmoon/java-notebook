package ch17.stdio5;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws IOException {
        final String CURRENT_DIR = "./xyz/icexmoon/java_notes/ch17/stdio5/";
        final String FILE = CURRENT_DIR + "Main.java";
        final String DES_FILE = CURRENT_DIR + "data.out";
        InputStream stdin = System.in;
        PrintStream stdout = System.out;
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(FILE));
        System.setIn(bis);
        PrintStream ps = new PrintStream(DES_FILE);
        System.setOut(ps);
        try {
            copyInput2Output(System.in, System.out);
        } finally {
            bis.close();
            ps.close();
        }
        System.setIn(stdin);
        System.setOut(stdout);
    }

    private static void copyInput2Output(InputStream in, PrintStream out) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        do {
            String line = br.readLine();
            if (null == line) {
                break;
            }
            out.println(line);
        } while (true);
    }
}
