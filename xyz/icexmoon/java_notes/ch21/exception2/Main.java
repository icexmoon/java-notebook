package ch21.exception2;

class ExceptionThread extends Thread {
    @Override
    public void run() {
        throw new RuntimeException("ExceptionThread's exp.");
    }
}

class ThreadExpHandle implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("thread exp " + e + " is caught.");
    }
}

public class Main {
    private static ExceptionThread exceptionThread;

    public static void main(String[] args) {
        exceptionThread = new ExceptionThread();
        exceptionThread.setUncaughtExceptionHandler(new ThreadExpHandle());
        exceptionThread.start();
    }
}
// thread exp java.lang.RuntimeException: ExceptionThread's exp. is caught.