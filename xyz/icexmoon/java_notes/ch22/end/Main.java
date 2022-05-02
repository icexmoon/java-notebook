package ch22.end;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import util.Fmt;

class Counter {
    private int total;

    public synchronized void increase() {
        total++;
    }

    public synchronized int getTotal() {
        return total;
    }
}

class Entrance implements Runnable {
    private static final Counter COUNTER = new Counter();
    private int total;
    private int id;
    private static volatile boolean canceled = false;
    private static List<Entrance> entrances = new ArrayList<>();

    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }

    public static void cancel() {
        canceled = true;
    }

    public static boolean isCancel() {
        return canceled;
    }

    @Override
    public void run() {
        while (!canceled) {
            synchronized (this) {
                total++;
            }
            COUNTER.increase();
            System.out.println(this + " total:" + COUNTER.getTotal());
        }
        System.out.println(this + " is closed, total:" + COUNTER.getTotal());
    }

    @Override
    public synchronized String toString() {
        return Fmt.sprintf("Gate#%d,nums:%d", id, total);
    }

    public synchronized int getTotal() {
        return total;
    }

    public static int getSumTotal() {
        int total = 0;
        for (Entrance entrance : entrances) {
            total += entrance.getTotal();
        }
        return total;
    }
}

public class Main {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            es.execute(new Entrance(i + 1));
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Entrance.cancel();
        es.shutdown();
        try {
            if(!es.awaitTermination(3, TimeUnit.SECONDS)){
                System.out.println("task is not end all.");
            } 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("total: " + Entrance.getSumTotal());
    }
}
// Gate#2,nums:2205 is closed, total:6517
// Gate#1,nums:2083 total:6517
// Gate#3,nums:2229 is closed, total:6517
// Gate#1,nums:2083 is closed, total:6517
// total: 6517