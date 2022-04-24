package ch21.critical2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import util.Fmt;

class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public void increaseX() {
        x++;
    }

    public void increaseY() {
        y++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Pair(%d,%d)", x, y);
    }

    public class PairValueNotEqualException extends RuntimeException {
        public PairValueNotEqualException() {
            super("Pair vlaue not equal:" + Pair.this);
        }
    }

    public void check() {
        if (x != y) {
            throw new PairValueNotEqualException();
        }
    }
}

abstract class PairManager {
    public AtomicInteger checkCounter = new AtomicInteger();
    protected List<Pair> pairs = Collections.synchronizedList(new ArrayList<>());
    protected Pair pair = new Pair();
    protected Lock lock = new ReentrantLock();

    public Pair getPair() {
        lock.lock();
        try {
            return new Pair(pair.getX(), pair.getY());
        } finally {
            lock.unlock();
        }
    }

    protected void store(Pair pair) {
        pairs.add(pair);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract void increase();

    @Override
    public String toString() {
        lock.lock();
        try {
            return Fmt.sprintf("%s, check counter:%d", pair, checkCounter.get());
        } finally {
            lock.unlock();
        }
    }
}


class PairManager2 extends PairManager {

    @Override
    public void increase() {
        Pair pairCopy;
        lock.lock();
        try {
            pair.increaseX();
            pair.increaseY();
            pairCopy = getPair();
        } finally {
            lock.unlock();
        }
        store(pairCopy);
    }

}

class PairIncrseTask implements Runnable {
    PairManager pairManager;

    public PairIncrseTask(PairManager pairManager) {
        this.pairManager = pairManager;
    }

    @Override
    public void run() {
        while (true) {
            pairManager.increase();
        }
    }

}

class PairCheckTask implements Runnable {
    PairManager pairManager;

    public PairCheckTask(PairManager pairManager) {
        this.pairManager = pairManager;
    }

    @Override
    public void run() {
        while (true) {
            pairManager.getPair().check();
            pairManager.checkCounter.incrementAndGet();
        }
    }

}

public class Main {
    public static void main(String[] args) {
        PairManager pm2;
        pm2 = new PairManager2();
        ExecutorService es = Executors.newCachedThreadPool();
        startPMCheck(pm2, es);
        es.shutdown();
        try {
            TimeUnit.MICROSECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("pm2:" + pm2);
        System.exit(0);
    }

    private static void startPMCheck(PairManager pm, ExecutorService es) {
        es.execute(new PairIncrseTask(pm));
        es.execute(new PairCheckTask(pm));
    }

}
// pm2:Pair(1,1), check counter:383