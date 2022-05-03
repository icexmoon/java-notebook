package ch23.countdown_latch;

import java.util.Random;
import java.util.concurrent.TimeUnit;

class CharacterPrinter implements Runnable {
    private static char counter = 'a';
    private static Random rand = new Random();
    private char character = counter++;

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(character + " ");
    }

}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int SIZE = 10;
        Thread[] threads = new Thread[SIZE];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new CharacterPrinter());
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println();
        System.out.println("all task is over.");
    }
}
// c b d h i j a e g f 
// all task is over.
