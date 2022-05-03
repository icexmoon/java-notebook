package ch23.schedule;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class SmartTV {
    @SuppressWarnings("unused")
    private boolean on = false;

    public synchronized void on() {
        this.on = true;
        System.out.println("tv is turn on.");
    }

    public synchronized void off() {
        this.on = false;
        System.out.println("tv is turn off.");
    }
}

class TVOnTask implements Runnable {
    private SmartTV tv;

    public TVOnTask(SmartTV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        tv.on();
    }
}

class TVOffTask implements Runnable {
    private SmartTV tv;

    public TVOffTask(SmartTV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        tv.off();
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int SIZE = 5;
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(SIZE);
        SmartTV tv = new SmartTV();
        executor.schedule(new TVOnTask(tv), 500, TimeUnit.MILLISECONDS);
        executor.schedule(new TVOffTask(tv), 2, TimeUnit.SECONDS);
        executor.shutdown();
    }
}
// tv is turn on.
// tv is turn off.