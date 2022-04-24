package ch21.local;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import util.Fmt;

class IntegerGenerator {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>() {
        private static Random rand = new Random();

        protected Integer initialValue() {
            return Integer.valueOf(rand.nextInt(10000));
        };
    };

    public static void increase() {
        threadLocal.set(threadLocal.get() + 1);
    }

    public static int next() {
        increase();
        return threadLocal.get();
    }

    public static int get() {
        return threadLocal.get();
    }
}

class NextTask implements Runnable {
    private int id;

    public NextTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            IntegerGenerator.next();
            System.out.println(this);
            Thread.yield();
        }
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Task#%d(%d)", id, IntegerGenerator.get());
    }

}

public class Main {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            es.execute(new NextTask(i));
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
// Task#0(14793)
// Task#1(14830)
// Task#2(14862)
// Task#1(14831)
// Task#0(14794)
// Task#1(14832)
// Task#2(14863)