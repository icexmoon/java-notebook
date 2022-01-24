package ch10.finally5;

class MyExp extends Exception {
}

public class Main {
    public static void main(String[] args) throws MyExp {
        try {
            throw new MyExp();
        } finally {
            System.out.println("finally block is executed.");
        }
    }
}
// finally block is executed.
// Exception in thread "main" ch10.finally5.MyExp
//         at ch10.finally5.Main.main(Main.java:9)
