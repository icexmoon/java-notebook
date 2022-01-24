package ch10.stack_trace4;

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
            MyExp newExp = new MyExp();
            newExp.initCause(e);
            throw newExp;
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (MyExp e) {
            e.printStackTrace();
            // ch10.stack_trace4.MyExp
            //         at ch10.stack_trace4.Main.g(Main.java:15)
            //         at ch10.stack_trace4.Main.main(Main.java:23)
            // Caused by: ch10.stack_trace4.MyExp
            //         at ch10.stack_trace4.Main.f(Main.java:8)
            //         at ch10.stack_trace4.Main.g(Main.java:13)
            //         ... 1 more
        }
    }
}
