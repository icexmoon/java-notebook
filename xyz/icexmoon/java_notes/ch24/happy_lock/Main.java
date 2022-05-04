package ch24.happy_lock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class HappyLock implements Runnable {
    private static final int DIMENSION1 = 10;
    private static final int DIMENSION2 = 15;
    private AtomicInteger[][] data = new AtomicInteger[DIMENSION1][DIMENSION2];
    private static Random rand = new Random();

    public HappyLock() {
        for (int i = 0; i < DIMENSION1; i++) {
            for (int j = 0; j < DIMENSION2; j++) {
                data[i][j] = new AtomicInteger(rand.nextInt(100));
            }
        }
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            int indexX = rand.nextInt(DIMENSION1);
            for (int j = 0; j < DIMENSION2; j++) {
                int oldValue = data[indexX][j].get();
                // Thread.yield();
                int preIndex = (indexX - 1) < 0 ? DIMENSION1 - 1 : indexX - 1;
                int preValue = data[preIndex][j].get();
                int afterValue = data[(indexX + 1) % DIMENSION1][j].get();
                int newValue = (oldValue + preValue + afterValue) / 3;
                boolean result = data[indexX][j].compareAndSet(oldValue, newValue);
                if (!result) {
                    System.out.println("Data changed by others, drop now change operation.");
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        HappyLock hl = new HappyLock();
        for (int i = 0; i < 10; i++) {
            es.execute(hl);
        }
        es.awaitTermination(5, TimeUnit.SECONDS);
        es.shutdownNow();
    }
}
