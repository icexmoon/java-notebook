package ch10.create4;

public class Main {
    private static double divide(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        System.out.println(divide(1, 5));
        System.out.println(divide(10, 0));
        // 0.0
        // Exception in thread "main" java.lang.ArithmeticException: / by zero
        //         at ch10.create4.Main.divide(Main.java:5)
        //         at ch10.create4.Main.main(Main.java:10)
    }
}
