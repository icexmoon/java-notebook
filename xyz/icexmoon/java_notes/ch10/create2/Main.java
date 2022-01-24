package ch10.create2;

public class Main {
    private static void testException(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        System.out.println(o.toString());
    }

    public static void main(String[] args) {
        testException("Hello World!");
        testException(null);
        // Hello World!
        // Exception in thread "main" java.lang.NullPointerException
        // at ch10.create2.Main.testException(Main.java:9)
        // at ch10.create2.Main.main(Main.java:16)
    }
}
