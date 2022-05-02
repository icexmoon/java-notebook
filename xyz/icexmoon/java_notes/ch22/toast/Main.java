package ch22.toast;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import util.Fmt;

class Cooker1 implements Runnable {
    private BlockingQueue<Toast> queue;
    private int delay;

    public Cooker1(BlockingQueue<Toast> queue, int delay) {
        this.queue = queue;
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.SECONDS.sleep(delay);
                Toast t = new Toast();
                System.out.println(t + " is cooked.");
                queue.put(t);
            }
        } catch (InterruptedException e) {
            ;
        }
    }

}

class Cooker2 implements Runnable {
    private int delay;
    private BlockingQueue<Toast> dry;
    private BlockingQueue<Toast> buttered;

    public Cooker2(int delay, BlockingQueue<Toast> dry, BlockingQueue<Toast> buttered) {
        this.delay = delay;
        this.dry = dry;
        this.buttered = buttered;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast toast = dry.take();
                TimeUnit.SECONDS.sleep(delay);
                toast.hasButter = true;
                System.out.println(toast + " is buttered.");
                buttered.put(toast);
            }
        } catch (InterruptedException e) {
            ;
        }
    }
}

class Cooker3 implements Runnable {
    private int delay;
    private BlockingQueue<Toast> buttered;

    public Cooker3(int delay, BlockingQueue<Toast> buttered) {
        this.delay = delay;
        this.buttered = buttered;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = buttered.take();
                TimeUnit.SECONDS.sleep(delay);
                t.hasJam = true;
                System.out.println(t + " is jamed.");
            }
        } catch (InterruptedException e) {
            ;
        }
    }

}

class Toast {
    private static int counter = 1;
    private final int id = counter++;
    boolean hasButter = false;
    boolean hasJam = false;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Toast#%d(hasButter:%s,hasJam:%s)", id, hasButter, hasJam);
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        BlockingQueue<Toast> dry = new ArrayBlockingQueue<>(3);
        BlockingQueue<Toast> buttered = new ArrayBlockingQueue<>(3);
        BlockingQueue<Toast> jamed = new ArrayBlockingQueue<>(3);
        es.execute(new Cooker1(dry, 1));
        es.execute(new Cooker2(1, dry, buttered));
        es.execute(new Cooker3(1, buttered));
        TimeUnit.SECONDS.sleep(5);
        es.shutdownNow();
    }
}
// Toast#1(hasButter:false,hasJam:false) is cooked.
// Toast#2(hasButter:false,hasJam:false) is cooked.
// Toast#1(hasButter:true,hasJam:false) is buttered.
// Toast#2(hasButter:true,hasJam:false) is buttered.
// Toast#1(hasButter:true,hasJam:true) is jamed.
// Toast#3(hasButter:false,hasJam:false) is cooked.
// Toast#2(hasButter:true,hasJam:true) is jamed.
// Toast#3(hasButter:true,hasJam:false) is buttered.
// Toast#4(hasButter:false,hasJam:false) is cooked.