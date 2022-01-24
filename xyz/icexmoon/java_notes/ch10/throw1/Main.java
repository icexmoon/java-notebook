
package ch10.throw1;

class MyException extends Exception {

}

public class Main {
    private static void throwCheckedException() throws MyException {
        throw new MyException();
    }

    private static void throwUnCheckedException() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        try {
            throwCheckedException();
        } catch (MyException e) {
            e.printStackTrace();
        }
        throwUnCheckedException();
        // ch10.throw1.MyException
        //         at ch10.throw1.Main.throwCheckedException(Main.java:10)
        //         at ch10.throw1.Main.main(Main.java:19)
        // Exception in thread "main" java.lang.RuntimeException
        //         at ch10.throw1.Main.throwUnCheckedException(Main.java:14)
        //         at ch10.throw1.Main.main(Main.java:23)
    }
}
