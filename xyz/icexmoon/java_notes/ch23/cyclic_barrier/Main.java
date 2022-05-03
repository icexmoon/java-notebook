package ch23.cyclic_barrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class CharacterPrinter implements Runnable {
    private static char counter = 'a';
    private static Random rand = new Random();
    private char character = counter++;
    private CyclicBarrier cb;

    public CharacterPrinter(CyclicBarrier cb) {
        this.cb = cb;
    }

    @Override
    public void run() {
        try {
            try {
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(character + " ");
        } finally {
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}

public class Main {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        final int SIZE = 10;
        ExecutorService es = Executors.newCachedThreadPool();
        CyclicBarrier cb = new CyclicBarrier(SIZE + 1);
        for (int i = 0; i < SIZE; i++) {
            es.execute(new CharacterPrinter(cb));
        }
        cb.await();
        System.out.println();
        System.out.println("all task is over.");
        es.shutdown();
    }
}
// c b d h i j a e g f
// all task is over.
