package ch19.values;

enum Color {
    RED, YELLOW, GREEN, BLUE
}

public class Main {
    public static void main(String[] args) {
        Color[] colors = Color.RED.values();
        System.out.println(colors);
        Enum e = Color.RED;
        // colors = e.values();
    }
}
