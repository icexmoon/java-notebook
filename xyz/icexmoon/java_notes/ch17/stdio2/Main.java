package ch17.stdio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            String line = br.readLine();
            if (line == null || line.length() == 0) {
                break;
            }
            String uppedLine = line.toUpperCase();
            System.out.println(uppedLine);
        } while (true);
    }
}