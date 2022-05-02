package ch22.block;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockBlock implements Runnable {
    ReentrantLock lock = new ReentrantLock();

    public ReentrantLockBlock() {
        lock.lock();
    }

    @Override
    public void run() {
        try {
            System.out.println("wait lock and blocked.");
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            if (Thread.interrupted()) {
                System.out.println("interrupt is happen.");
            }
            System.out.println(e);
        }
    }

}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ReentrantLockBlock());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        t.interrupt();
    }
}
// wait lock and blocked.
// java.lang.InterruptedException