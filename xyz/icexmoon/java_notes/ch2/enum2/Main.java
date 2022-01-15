package ch2.enum2;

enum Color {
    BLACK, BLUE, RED, GREEN
}

public class Main {
    private static boolean isLightColor(Color color) {
        switch (color) {
            case RED:
            case BLUE:
            case GREEN:
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isLightColor(Color.BLACK));
        System.out.println(isLightColor(Color.GREEN));
        // false
        // true
    }
}
