package ch10.create5;

public class Main {
    private static double divide(double a, double b) {
        if ((b - 0) < 0.0001) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    public static void main(String[] args) {
        System.out.println(divide(1, 5));
        System.out.println(divide(10, 0));
        // 0.2
        // Exception in thread "main" java.lang.ArithmeticException
        // at ch10.create3.Main.divide(Main.java:13)
        // at ch10.create3.Main.main(Main.java:21)
    }
}
