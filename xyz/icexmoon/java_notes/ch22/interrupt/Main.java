package ch22.interrupt;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

class SleepInterrupt implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("sleeped and block...");
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("interrupt is happen.");
        }
    }

}

class IOInterrupt implements Runnable{
    private InputStream input;
    public IOInterrupt(InputStream input){
        this.input = input;
    }

    @Override
    public void run() {
        System.out.println("wait for io read and block...");
        try {
            input.read();
        } catch (IOException e) {
            if(Thread.interrupted()){
                System.out.println("interrupt is happen.");
            }
            e.printStackTrace();
        }

    }

}

class SyncMethodInterrupt implements Runnable{
    public SyncMethodInterrupt(){
        new Thread(){
            @Override
            public void run() {
                synchronized(SyncMethodInterrupt.class){
                    while(true){
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
    }

    @Override
    public void run() {
        System.out.println("require sync lock and block...");
        synchronized(SyncMethodInterrupt.class){
            Thread.yield();
        }
        if(Thread.interrupted()){
            System.out.println("interrupt is happen.");
        }
    }

}

public class Main {
    public static void main(String[] args) {
        testInterruptTask(new SleepInterrupt());
        testInterruptTask(new IOInterrupt(System.in));
        testInterruptTask(new SyncMethodInterrupt());
    }

    private static void testInterruptTask(Runnable task) {
        Thread thread = new Thread(task);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
            thread.interrupt();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
// sleeped and block...
// interrupt is happen.
// wait for io read and block...
// require sync lock and block...