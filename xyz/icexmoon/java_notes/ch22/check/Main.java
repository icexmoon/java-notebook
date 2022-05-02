package ch22.check;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class OddWriter implements Runnable {
    private int num = 1;

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.print(num + " ");
                num += 2;
                TimeUnit.MILLISECONDS.sleep(500);
            }
        } catch (InterruptedException e) {
            ;
        }
        System.out.println();
        System.out.println("OddWriter is exit.");
    }
}

class EvenWriter implements Runnable {
    private int num = 0;

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.print(num + " ");
                num += 2;
                TimeUnit.MILLISECONDS.sleep(500);
            }
        } catch (InterruptedException e) {
            ;
        }
        System.out.println();
        System.out.println("EvenWriter is exit.");
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new EvenWriter());
        TimeUnit.MILLISECONDS.sleep(100);
        es.execute(new OddWriter());
        TimeUnit.SECONDS.sleep(3);
        es.shutdownNow();
    }
}
// 0 1 2 3 4 5 6 7 8 9 10 11 12 
// OddWriter is exit.

// EvenWriter is exit.
