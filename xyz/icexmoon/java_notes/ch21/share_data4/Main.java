package ch21.share_data4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class EvenGenerator {
    private int even = 0;
    private boolean isAlive = true;

    synchronized public int next() {
        even++;
        Thread.yield();
        even++;
        return even;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void cancel() {
        isAlive = false;
    }

}

public class Main {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        test(5, es);
        es.shutdown();
    }

    private static void test(int times, ExecutorService es) {
        EvenGenerator eg = new EvenGenerator();
        for (int i = 0; i < times; i++) {
            es.execute(new Runnable() {

                @Override
                public void run() {
                    while (eg.isAlive()) {
                        int even = eg.next();
                        if (even % 2 != 0) {
                            System.out.println(even + " is not even number.");
                            eg.cancel();
                        }
                    }
                }

            });
        }
    }
}