package ch21.coding3;

class SimpleTask {
    private InnerCls ic = new InnerCls();
    {
        ic.start();
    }

    private static class InnerCls extends Thread {
        @Override
        public void run() {
            System.out.println("task is running.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        new SimpleTask();
    }
}
