package ch21.coding5;

class SimpleTask {
    public SimpleTask() {
        new Thread() {
            @Override
            public void run() {
                System.out.println("task is running.");
            }
        }.start();
    }
}

public class Main {
    public static void main(String[] args) {
        new SimpleTask();
    }
}
