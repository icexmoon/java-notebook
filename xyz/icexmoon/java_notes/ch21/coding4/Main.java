package ch21.coding4;

class SimpleTask {
    private Thread ic = new Thread() {
        @Override
        public void run() {
            System.out.println("task is running.");
        }
    };
    {
        ic.start();
    }
}

public class Main {
    public static void main(String[] args) {
        new SimpleTask();
    }
}
