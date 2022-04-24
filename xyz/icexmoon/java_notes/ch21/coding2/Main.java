package ch21.coding2;

class SimpleTask implements Runnable {

    public SimpleTask() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("task is running.");
    }

}   

public class Main {
    public static void main(String[] args) {
        new SimpleTask();
    }
}
