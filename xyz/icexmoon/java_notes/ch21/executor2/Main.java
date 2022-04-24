package ch21.executor2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

public class Main {
    public static void main(String[] args) {
        final int MAX_TASK = 3;
        ExecutorService es = Executors.newFixedThreadPool(MAX_TASK);
        for (int i = 0; i < MAX_TASK; i++) {
            es.execute(new SimpleTask(i));
        }
    }
}
