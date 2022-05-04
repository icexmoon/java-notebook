package ch24.restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

import ch24.restaurant.Meal.Type;
import util.Enums;
import util.Fmt;

class Meal {
    public static enum Type {
        HAMBURG, CHIPS, FRIED_CHIKEN
    }

    private static int counter = 0;
    private final int id = ++counter;
    private Type type;

    public Meal(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Meal#%d(%s)", id, type);
    }
}

class Order {
    private Customer customer;
    private Waiter waiter;
    private Meal.Type mealType;
    private Meal meal;

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public Customer getConsumer() {
        return customer;
    }

    public void setConsumer(Customer customer) {
        this.customer = customer;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public Meal.Type getMealType() {
        return mealType;
    }

    public void setMealType(Meal.Type mealType) {
        this.mealType = mealType;
    }

    public Order(Customer customer, Waiter waiter, Type mealType) {
        this.customer = customer;
        this.waiter = waiter;
        this.mealType = mealType;
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Order(%s) created by %s to %s", mealType, customer, waiter);
    }
}

class Restaurant implements Runnable {
    private BlockingQueue<Order> orders = new ArrayBlockingQueue<>(20);
    private List<Chef> chefs = new ArrayList<>();
    private List<Waiter> waiters = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private static Random rand = new Random();
    private ExecutorService es;

    public Restaurant(int chefNum, int waiterNum, ExecutorService es) {
        this.es = es;
        for (int i = 0; i < chefNum; i++) {
            this.chefs.add(new Chef(this));
        }
        for (int i = 0; i < waiterNum; i++) {
            this.waiters.add(new Waiter());
        }
    }

    public Order getOrder() throws InterruptedException {
        return orders.take();
    }

    public void addOrder(Order order) throws InterruptedException {
        orders.put(order);
    }

    @Override
    public void run() {
        for (Chef chef : chefs) {
            es.execute(chef);
        }
        for (Waiter waiter : waiters) {
            es.execute(waiter);
        }
        int counter = 0;
        while (!Thread.interrupted()) {
            Customer customer = new Customer();
            this.customers.add(customer);
            int waiterIndex = rand.nextInt(waiters.size());
            Waiter waiter = waiters.get(waiterIndex);
            Type mealType = Enums.random(Meal.Type.class);
            Order newOrder = new Order(customer, waiter, mealType);
            System.out.println(newOrder);
            try {
                this.addOrder(newOrder);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //顾客准备就餐
            es.execute(customer);
            counter++;
            if (counter > 5) {
                break;
            }
        }
    }
}

class Chef implements Runnable {
    private static int counter = 0;
    private final int id = ++counter;
    private Restaurant restaurant;
    private static Random rand = new Random();

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Order order = restaurant.getOrder();
                // cook meal
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(500) + 500);
                Meal meal = new Meal(order.getMealType());
                System.out.println(meal + " is cooked by" + this);
                order.setMeal(meal);
                order.getWaiter().addCookedOrder(order);
            }
        } catch (InterruptedException e) {
            // e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Chef#%d", id);
    }
}

class Waiter implements Runnable {
    private static int counter = 0;
    private final int id = ++counter;
    private BlockingQueue<Order> cooked = new LinkedBlockingQueue<>();

    public void addCookedOrder(Order order) throws InterruptedException {
        cooked.put(order);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // 有做好的菜就传给顾客
                Order order = cooked.take();
                System.out.println(
                        this + " get cooked meal " + order.getMeal() + " and serve meal to " + order.getConsumer());
                order.getConsumer().serveMeal(order.getMeal());
            }
        } catch (InterruptedException e) {
            // e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Waiter#%d", id);
    }
}

class Customer implements Runnable {
    private static int counter = 0;
    private int id = ++counter;
    private SynchronousQueue<Meal> desk = new SynchronousQueue<>(); // 顾客的桌子只能放一道菜
    private static Random rand = new Random();

    public void serveMeal(Meal meal) throws InterruptedException {
        desk.put(meal);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Meal meal = desk.take();
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(500) + 200);
                System.out.println(meal + " is eated by " + this);
            }
        } catch (InterruptedException e) {
            // e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return Fmt.sprintf("Customer#%d", id);
    }

}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new Restaurant(1, 2, es));
        es.awaitTermination(3, TimeUnit.SECONDS);
        es.shutdownNow();
    }
}
