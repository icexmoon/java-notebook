package ch21.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TryLock {
    public Lock lock = new ReentrantLock();

    public void noTime() {
        if (lock.tryLock()) {
            try {
                System.out.println("noTime() get lock success.");
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("noTime() get lock failed.");
        }
    }

    public void timed() {
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    System.out.println("timed() get lock success.");
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("timed() get lock failed.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TryLock tl = new TryLock();
        ExecutorService es = Executors.newCachedThreadPool();
        testTryLock(tl, es);
        tl.lock.lock();
        testTryLock(tl, es);
        es.shutdown();
    }

    private static void testTryLock(TryLock tl, ExecutorService es) {
        Thread t1, t2;
        t1 = new Thread(){
            public void run() {
                tl.noTime();
            };
        };
        t2 = new Thread(){
            public void run() {
                tl.timed();
            };
        };
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
// noTime() get lock success.
// timed() get lock success.
// noTime() get lock failed.
// timed() get lock failed.