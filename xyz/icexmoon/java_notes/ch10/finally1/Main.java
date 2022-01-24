package ch10.finally1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String fn = "D:\\workspace\\java\\java-notebook\\xyz\\icexmoon\\java_notes\\ch10\\catch4\\exp.log";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fn));
            String line = null;
            do {
                line = br.readLine();
                System.out.println(line);
            } while (line != null);
            try {
                br.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            try {
                br.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
