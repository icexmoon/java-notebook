package ch21.join;

import util.Fibnacci;

class SimpleTask extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            System.out.print(Fibnacci.fibnacci(i) + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t = new SimpleTask();
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("program is exit.");
    }
}
// 1 1 2 3 5 8 13 21 34 55 
// program is exit.
