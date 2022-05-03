package ch23.exchanger;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import util.Fmt;

class Meal {
    private static int counter = 0;
    private final int id = ++counter;

    @Override
    public String toString() {
        return Fmt.sprintf("Meal#%d", id);
    }
}

class ProducerTask implements Runnable {
    private Exchanger<List<Meal>> exchanger;

    public ProducerTask(Exchanger<List<Meal>> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            List<Meal> meals = new CopyOnWriteArrayList<>();
            while (!Thread.interrupted()) {
                for (int i = 0; i < 5; i++) {
                    Meal meal = new Meal();
                    System.out.println(meal + " is cooked.");
                    meals.add(meal);
                }
                meals = exchanger.exchange(meals);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            // System.out.println("");
        }
    }
}

class ConsumerTask implements Runnable {
    private Exchanger<List<Meal>> exchanger;

    public ConsumerTask(Exchanger<List<Meal>> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        List<Meal> meals = new CopyOnWriteArrayList<>();
        try {
            while (!Thread.interrupted()) {
                meals = exchanger.exchange(meals);
                for (Meal meal : meals) {
                    System.out.println(meal + " is eated.");
                    meals.remove(meal);
                }
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            // e.printStackTrace();
        }

    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        Exchanger<List<Meal>> exchanger = new Exchanger<>();
        es.execute(new ConsumerTask(exchanger));
        es.execute(new ProducerTask(exchanger));
        es.awaitTermination(5, TimeUnit.SECONDS);
        es.shutdownNow();
    }
}
