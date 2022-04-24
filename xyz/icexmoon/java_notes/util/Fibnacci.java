package util;

public class Fibnacci {
    public static int fibnacci(int n) {
        if (n <= 2) {
            return 1;
        }
        return fibnacci(n - 1) + fibnacci(n - 2);
    }
}
