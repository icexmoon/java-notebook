package ch10.create6;

class MyExcetion extends Exception {
    public MyExcetion(String msg) {
        super(msg);
    }
}

public class Main {
    private static void testException() throws MyExcetion {
        throw new MyExcetion("this is a message.");
    }

    public static void main(String[] args) {
        try {
            testException();
        } catch (Exception e) {
            e.printStackTrace();
            // ch10.create6.MyExcetion: this is a message.
            // at ch10.create6.Main.testException(Main.java:11)
            // at ch10.create6.Main.main(Main.java:16)
        }
    }
}
