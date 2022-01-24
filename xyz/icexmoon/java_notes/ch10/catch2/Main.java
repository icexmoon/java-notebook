package ch10.catch2;

class MyException extends Exception {
}

public class Main {
    private static void g() throws MyException {
        throw new MyException();
    }

    private static void f() throws MyException {
        g();
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace();
            // ch10.catch2.MyException
            // at ch10.catch2.Main.g(Main.java:8)
            // at ch10.catch2.Main.f(Main.java:12)
            // at ch10.catch2.Main.main(Main.java:17)
        }
    }
}
