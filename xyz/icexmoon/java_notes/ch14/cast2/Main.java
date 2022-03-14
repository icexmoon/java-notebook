package ch14.cast2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = (List<String>)readString("Hello world, how are you.");
        // Type safety: Unchecked cast from Object to List<String>Java(16777761)
        System.out.println(words);
    }

    private static Object readString(String str) {
        List<String> list = new ArrayList<>(Arrays.asList(str.split(" ")));
        return list;
    }
}
// [Hello, world,, how, are, you.]