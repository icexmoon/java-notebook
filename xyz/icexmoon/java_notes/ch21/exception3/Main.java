package ch21.exception3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

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

class ExpCaughtThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setUncaughtExceptionHandler(new ThreadExpHandle());
        return t;
    }

}

public class Main {

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool(new ExpCaughtThreadFactory());
        for (int i = 0; i < 3; i++) {
            es.execute(new ExceptionTask());
        }
        es.shutdown();
    }
}
// thread exp java.lang.RuntimeException: ExceptionThread's exp. is caught.
// thread exp java.lang.RuntimeException: ExceptionThread's exp. is caught.
// thread exp java.lang.RuntimeException: ExceptionThread's exp. is caught.