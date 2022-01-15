package ch2.enum1;

enum Color {
    BLACK, BLUE, RED, GREEN
}

public class Main {
    public static void main(String[] args) {
        for (Color color : Color.values()) {
            int key = color.ordinal();
            String name = color.toString();
            System.out.println(key + "=" + name);
        }
        // 0=BLACK
        // 1=BLUE
        // 2=RED
        // 3=GREEN
    }
}
