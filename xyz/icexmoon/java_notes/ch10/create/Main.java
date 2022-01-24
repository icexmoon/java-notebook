package ch10.create;

class MyExcetion extends Exception {
}

public class Main {
    private static void testException() throws MyExcetion {
        throw new MyExcetion();
    }

    public static void main(String[] args) {
        try {
            testException();
        } catch (Exception e) {
            e.printStackTrace();
            // ch10.create.MyExcetion
            // at ch10.create.Main.testException(Main.java:8)
            // at ch10.create.Main.main(Main.java:13)
        }
    }
}
