package ch21.coding;

class SimpleTask extends Thread{
    public SimpleTask(){
        super();
        this.start();
    }

    @Override
    public void run() {
        System.out.println("task is running");
    }
}

public class Main {
    public static void main(String[] args) {
        new SimpleTask();
    }
}
