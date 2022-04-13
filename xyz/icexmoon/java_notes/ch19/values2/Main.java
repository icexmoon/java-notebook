package ch19.values2;

import java.util.Arrays;

enum Color {
    RED, YELLOW, GREEN, BLUE
}

public class Main {
    public static void main(String[] args) {
        Color[] colors = Color.RED.values();
        System.out.println(Arrays.toString(colors));
        Enum e = Color.RED;
        // colors = e.values();
        Enum<Color>[] colors2 = e.getClass().getEnumConstants();
        System.out.println(Arrays.toString(colors2));
    }
}
// [RED, YELLOW, GREEN, BLUE]
// [RED, YELLOW, GREEN, BLUE]
