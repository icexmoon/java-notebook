package ch10.catch1;

class MyException extends Exception {
}

public class Main {
    public static void main(String[] args) {
        try {
            throw new MyException();
        } catch (MyException e) {
            ;
        }
    }
}
