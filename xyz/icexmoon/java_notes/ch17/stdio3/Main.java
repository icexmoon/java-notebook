package ch17.stdio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        do {
            String line = br.readLine();
            if (line == null || line.length() == 0) {
                break;
            }
            String uppedLine = line.toUpperCase();
            pw.println(uppedLine);
            pw.flush();
        } while (true);
    }
}