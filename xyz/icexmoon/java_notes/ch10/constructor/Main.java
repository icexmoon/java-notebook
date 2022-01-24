package ch10.constructor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FileInput {
    BufferedReader reader;

    public FileInput(String fname) throws FileNotFoundException {
        FileReader fr;
        try {
            fr = new FileReader(fname);
            reader = new BufferedReader(fr);
        } catch (FileNotFoundException e) {
            throw e;
        }
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }

    public void close() throws IOException {
        reader.close();
    }

}

public class Main {
    public static void main(String[] args) {
        String fname = "D:\\workspace\\java\\java-notebook\\xyz\\icexmoon\\java_notes\\ch10\\catch4\\exp.log";
        try {
            FileInput fi = new FileInput(fname);
            try {
                String line = null;
                do {
                    line = fi.readLine();
                    System.out.println(line);
                } while (line != null);
            } finally {
                fi.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
