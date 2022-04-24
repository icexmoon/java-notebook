package ch21.exception4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExceptionTask implements Runnable {
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

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new ThreadExpHandle());
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            es.execute(new ExceptionTask());
        }
        es.shutdown();
    }
}
// thread exp java.lang.RuntimeException: ExceptionThread's exp. is caught.
// thread exp java.lang.RuntimeException: ExceptionThread's exp. is caught.
// thread exp java.lang.RuntimeException: ExceptionThread's exp. is caught.