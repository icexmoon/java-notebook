package ch10.stack_trace3;

class MyExp extends Exception {
}

public class Main {
    private static void f() throws MyExp {
        throw new MyExp();
    }

    private static void g() throws MyExp {
        try {
            f();
        } catch (MyExp e) {
            e.fillInStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (MyExp e) {
            e.printStackTrace();
            // ch10.stack_trace3.MyExp
            // at ch10.stack_trace3.Main.g(Main.java:15)
            // at ch10.stack_trace3.Main.main(Main.java:22)
        }
    }
}
