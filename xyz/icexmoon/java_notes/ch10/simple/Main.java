package ch10.simple;

class MyExp extends Exception {
}

public class Main {
    public static void main(String[] args) throws MyExp {
        throw new MyExp();
    }
}
// Exception in thread "main" ch10.simple.MyExp
//         at ch10.simple.Main.main(Main.java:8)