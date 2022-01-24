package ch10.dispose;

class MyExp extends Exception {
}

class MyExp2 extends Exception {
}

public class Main {
    private static void throwMyExp2() throws MyExp2 {
        throw new MyExp2();
    }

    public static void main(String[] args) throws Exception {
        try {
            throw new MyExp();
        } finally {
            throwMyExp2();
        }
    }
}
// Exception in thread "main" ch10.dispose.MyExp2
//         at ch10.dispose.Main.throwMyExp2(Main.java:11)
//         at ch10.dispose.Main.main(Main.java:18)
