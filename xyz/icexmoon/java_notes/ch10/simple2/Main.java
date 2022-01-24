package ch10.simple2;

class MyExp extends Exception {
}

public class Main {
    public static RuntimeException exchangeExp(Exception e) {
        return new RuntimeException(e);
    }

    public static void main(String[] args) {
        try {
            throw new MyExp();
        } catch (MyExp e) {
            throw exchangeExp(e);
        }
    }
}
// Exception in thread "main" java.lang.RuntimeException: ch10.simple2.MyExp
//         at ch10.simple2.Main.exchangeExp(Main.java:8)
//         at ch10.simple2.Main.main(Main.java:15)
// Caused by: ch10.simple2.MyExp
//         at ch10.simple2.Main.main(Main.java:13)
