package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TextFile implements Iterable<String> {
    private List<String> lines = new LinkedList<>();

    public TextFile(String fileName, String sepRegex) {
        String content = read(fileName);
        lines.addAll(Arrays.asList(content.split(sepRegex)));
    }

    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    public void write(String fileName) {
        try {
            PrintWriter pw = new PrintWriter(fileName);
            try {
                for (String line : lines) {
                    pw.println(line);
                }
            } finally {
                pw.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String read(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            try {
                do {
                    String line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    sb.append("\n");
                } while (true);
            } finally {
                br.close();
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void write(String fileName, String content) {
        PrintWriter pw;
        try {
            pw = new PrintWriter(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            pw.print(content);
        } finally {
            pw.close();
        }
    }

    @Override
    public Iterator<String> iterator() {
        return lines.iterator();
    }

    public static void main(String[] args) {
        final String CURRENT_DIR = "./xyz/icexmoon/java_notes/util/";
        final String DES_FILE = CURRENT_DIR + "data.out";
        final String SOURCE_FILE = CURRENT_DIR + "TextFile.java";
        TextFile tf = new TextFile(SOURCE_FILE);
        tf.write(DES_FILE);
        TextFile tf2 = new TextFile(DES_FILE);
        for (String line : tf2) {
            System.out.println(line);
        }
    }
}
