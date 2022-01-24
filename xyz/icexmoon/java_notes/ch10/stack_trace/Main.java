package ch10.stack_trace;

import util.Fmt;

class MyExp extends Exception {
}

public class Main {
    private static void f() throws MyExp {
        throw new MyExp();
    }

    private static void g() throws MyExp {
        f();
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (MyExp e) {
            for (StackTraceElement ste : e.getStackTrace()) {
                Fmt.printf("line:%d method:%s\n", ste.getLineNumber(), ste.getMethodName());
            }
            // line:10 method:f
            // line:14 method:g
            // line:19 method:main
        }
    }
}
