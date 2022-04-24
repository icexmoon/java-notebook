package ch21.exception;

class ExceptionThread extends Thread {
    @Override
    public void run() {
        throw new RuntimeException("ExceptionThread's exp.");
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            new ExceptionThread().start();
        } catch (Exception e) {
            System.out.println(e + " is caught.");
        }
    }
}
// Exception in thread "Thread-0" java.lang.RuntimeException: ExceptionThread's exp.
//         at ch21.exception.ExceptionThread.run(Main.java:6)
