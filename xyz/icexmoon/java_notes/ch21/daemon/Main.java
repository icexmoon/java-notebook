package ch21.daemon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import util.Fmt;

class SimpleTask implements Runnable {
    private final int id;
    private int counter = 5;

    public SimpleTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        do {
            System.out.println(this);
            counter--;
            Thread.yield();
        } while (counter > 0);
    }

    @Override
    public String toString() {
        return Fmt.sprintf("#%d,counter=%d", id, counter);
    }

}

class DaemonThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }

}

public class Main {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 6; i++) {
            es.execute(new SimpleTask(i));
        }
        es.shutdown();
    }
}