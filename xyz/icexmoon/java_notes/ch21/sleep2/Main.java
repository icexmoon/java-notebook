package ch21.sleep2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.yield();
        } while (counter > 0);
    }

    @Override
    public String toString() {
        return Fmt.sprintf("#%d,counter=%d", id, counter);
    }

}

public class Main {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            es.execute(new SimpleTask(i));
        }
        es.shutdown();
    }
}
