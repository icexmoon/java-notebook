package ch21.join2;

import java.util.concurrent.TimeUnit;

import util.Fibnacci;

class SimpleTask extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            System.out.print(Fibnacci.fibnacci(i) + " ");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                System.out.println();
                System.out.println("fibnacci print is interrupted.");
                System.out.println("isInterrupted() "+this.isInterrupted());
                return;
            }
        }
        System.out.println();
    }
}

class InterruptThread extends Thread{
    private Thread t;
    public InterruptThread(Thread t){
        this.t = t;
    }
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t = new SimpleTask();
        Thread t2 = new InterruptThread(t);
        t.start();
        t2.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.println("SimpleTask is interrupted.");
        }
        System.out.println("program is exit.");
    }
}
// 1 1 2 
// fibnacci print is interrupted.
// isInterrupted() false
// program is exit.