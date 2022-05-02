package ch22.restaurant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import util.Fmt;

class Waiter implements Runnable {
    private Restaurant restaurant;

    public Waiter(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (restaurant) {
                    while (restaurant.bar == null) {
                        restaurant.wait();
                    }
                    Meal meal = restaurant.bar;
                    restaurant.bar = null;
                    System.out.println(meal + " is take by Waiter.");
                    restaurant.notifyAll();
                    if (meal.id > 5) {
                        break;
                    }
                }
            }
        } catch (InterruptedException e) {
            ;
        }
    }
}

class Chef implements Runnable {
    private Restaurant restaurant;
    private int mealId = 1;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (restaurant) {
                    while (restaurant.bar != null) {
                        restaurant.wait();
                    }
                    Meal meal = new Meal(mealId);
                    mealId++;
                    restaurant.bar = meal;
                    System.out.println(meal + " is build by Chef.");
                    restaurant.notifyAll();
                    if (meal.id > 5) {
                        break;
                    }
                }
            }
        } catch (InterruptedException e) {
            // e.printStackTrace();
        }
    }
}

class Restaurant {
    public Meal bar;
}

class Meal {
    public int id;

    public Meal(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Meal#%d", id);
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        Restaurant restaurant = new Restaurant();
        es.execute(new Waiter(restaurant));
        es.execute(new Chef(restaurant));
        es.shutdown();
    }
}
// Meal#1 is build by Chef.
// Meal#1 is take by Waiter.
// Meal#2 is build by Chef.
// Meal#2 is take by Waiter.
// Meal#3 is build by Chef.
// Meal#3 is take by Waiter.
// Meal#4 is build by Chef.
// Meal#4 is take by Waiter.
// Meal#5 is build by Chef.
// Meal#5 is take by Waiter.
// Meal#6 is build by Chef.
// Meal#6 is take by Waiter.