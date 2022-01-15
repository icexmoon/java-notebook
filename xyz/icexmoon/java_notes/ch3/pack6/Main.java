package ch3.pack6;

import java.io.FileWriter;
import java.io.IOException;

import util.Fmt;

public class Main {
    public static void main(String[] args) {
        String name = "icexmoon";
        int age = 16;
        Fmt.printf("My name is %s, my age is %d years old.\n", name, age);
        String msg = Fmt.sprintf("My name is %s, my age is %d years old.\n", name, age);
        System.out.println(msg);
        try {
            FileWriter fopen = new FileWriter("test.txt", true);
            Fmt.fprintf(fopen, "My name is %s, my age is %d years old.\n", name, age);
            fopen.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // My name is icexmoon, my age is 16 years old.
        // My name is icexmoon, my age is 16 years old.
    }
}
