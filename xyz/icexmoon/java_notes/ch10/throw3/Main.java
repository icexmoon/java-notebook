
package ch10.throw3;

class MyException extends Exception {
}

class MyException2 extends Exception {
}

public class Main {
    private static void throwCheckedException(int i) throws MyException, MyException2 {
        ;// do nothing.
    }

    public static void main(String[] args) {
        try {
            throwCheckedException(10);
        } catch (MyException e) {
            e.printStackTrace();
        } catch (MyException2 e) {
            e.printStackTrace();
        }
    }
}
