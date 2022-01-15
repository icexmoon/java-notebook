package ch4.final2;

class Colors {
    public static final int RED = 1;
    public static final int BLUE = 2;
    public static final int YELLOW = 3;
    public static final int BLACK = 4;
    public static final int GREEN = 5;

    public static boolean isLight(int code) {
        switch (code) {
            case BLUE:
            case YELLOW:
            case RED:
            case GREEN:
                return true;
            default:
                return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Colors.isLight(Colors.GREEN));
    }
}
