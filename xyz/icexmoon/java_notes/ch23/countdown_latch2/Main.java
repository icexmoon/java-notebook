package ch23.countdown_latch2;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class CharacterPrinter implements Runnable {
    private static char counter = 'a';
    private static Random rand = new Random();
    private char character = counter++;
    private CountDownLatch cdl;

    public CharacterPrinter(CountDownLatch cdl) {
        this.cdl = cdl;
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
            cdl.countDown();
        }
    }

}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int SIZE = 10;
        ExecutorService es = Executors.newCachedThreadPool();
        CountDownLatch cdl = new CountDownLatch(SIZE);
        for (int i = 0; i < SIZE; i++) {
            es.execute(new CharacterPrinter(cdl));
        }
        cdl.await();
        System.out.println();
        System.out.println("all task is over.");
        es.shutdown();
    }
}
// c b d h i j a e g f
// all task is over.
