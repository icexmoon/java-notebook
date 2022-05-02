package ch22.philosopher2;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import util.Fmt;

class Philosopher implements Runnable {
    private static int counter = 1;
    private final int id = counter++;
    private Chopstick left;
    private Chopstick right;
    private static Random random = new Random();
    private int delay;

    public Philosopher(Chopstick left, Chopstick right, int delay) {
        this.left = left;
        this.right = right;
        this.delay = delay;
    }

    @Override
    public void run() {
        pause();
        left.take();
        System.out.println(this + " take left chopstick.");
        right.take();
        System.out.println(this + " take right chopstick.");
        pause();
        left.drop();
        System.out.println(this + " drop left chopstick.");
        right.drop();
        System.out.println(this + " drop right chopstick.");
    }

    private void pause() {
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(250 * delay + 1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Philosohper#%d", id);
    }
}

class Chopstick {
    private boolean isUsed = false;

    public synchronized void take() {
        while (isUsed) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isUsed = true;
    }

    public synchronized void drop() {
        isUsed = false;
        notifyAll();
    }
}

public class Main {
    public static void main(String[] args) {
        test(5, 0);
    }

    public static void test(int num, int delay) {
        Chopstick[] chopsticks = new Chopstick[num];
        for (int i = 0; i < chopsticks.length; i++) {
            chopsticks[i] = new Chopstick();
        }
        Philosopher[] philosophers = new Philosopher[num];
        for (int i = 0; i < philosophers.length; i++) {
            if (i == num - 1) {
                philosophers[i] = new Philosopher(chopsticks[0], chopsticks[i], delay);
            } else {
                philosophers[i] = new Philosopher(chopsticks[i], chopsticks[i + 1], delay);
            }
        }
        ExecutorService es = Executors.newCachedThreadPool();
        for (Philosopher philosopher : philosophers) {
            es.execute(philosopher);
        }
        es.shutdown();
    }
}
// Philosohper#2 take left chopstick.
// Philosohper#3 take left chopstick.
// Philosohper#5 take left chopstick.
// Philosohper#1 take left chopstick.
// Philosohper#4 take left chopstick.