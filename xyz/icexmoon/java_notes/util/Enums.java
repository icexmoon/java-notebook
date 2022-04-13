package util;

import java.util.Random;

public class Enums {
    private static Random rand = new Random();

    public static <T extends Enum<T>> T random(Class<T> cls) {
        T[] constants = cls.getEnumConstants();
        return random(constants);
    }

    public static <T> T random(T[] arr) {
        return arr[rand.nextInt(arr.length)];
    }

    public static void main(String[] args) {
        enum Color {
            RED, BLUE, YELLOW
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(random(Color.class) + " ");
        }
        System.out.println();
    }
}
// BLUE YELLOW YELLOW BLUE RED