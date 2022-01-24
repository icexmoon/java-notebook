
package ch10.throw2;

class MyException extends Exception {
}

class MyException2 extends Exception {
}

public class Main {
    private static void throwCheckedException(int i) throws MyException, MyException2 {
        if (i > 10) {
            throw new MyException();
        } else {
            throw new MyException2();
        }
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
