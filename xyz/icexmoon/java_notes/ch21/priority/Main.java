package ch21.priority;

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

class HighPriorityThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setPriority(Thread.MAX_PRIORITY);
        return thread;
    }

}

public class Main {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        ExecutorService es2 = Executors.newCachedThreadPool(new HighPriorityThreadFactory());
        for (int i = 0; i < 6; i++) {
            if (i < 3) {
                es.execute(new SimpleTask(i));
            } else {
                es2.execute(new SimpleTask(i));
            }
        }
        es.shutdown();
        es2.shutdown();
    }
}
// #3,counter=5
// #3,counter=4
// #3,counter=3
// #3,counter=2
// #3,counter=1
// #0,counter=5
// #1,counter=5
// #2,counter=5
// #5,counter=5
// #4,counter=5
// #5,counter=4
// #4,counter=4
// #5,counter=3
// #4,counter=3
// #5,counter=2
// #4,counter=2
// #5,counter=1
// #4,counter=1
// #1,counter=4
// #2,counter=4
// #1,counter=3
// #0,counter=4
// #2,counter=3
// #1,counter=2
// #0,counter=3
// #2,counter=2
// #1,counter=1
// #0,counter=2
// #2,counter=1
// #0,counter=1