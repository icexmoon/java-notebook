package ch21.thread;

import util.Fmt;

class SimpleThread extends Thread {
    private int counter = 5;
    private final int id;

    public SimpleThread(int id) {
        super();
        this.id = id;
    }

    @Override
    public void run() {
        do {
            System.out.println(this);
            counter--;
            Thread.yield();
        } while (counter > 0);
    }

    @Override
    public String toString() {
        return Fmt.sprintf("#%d,counter=%d", id, counter);
    }

}

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new SimpleThread(i);
            thread.start();
        }
    }
}
// #1,counter=5
// #0,counter=5
// #2,counter=5
// #0,counter=4
// #1,counter=4
// #2,counter=4
// #0,counter=3
// #1,counter=3
// #2,counter=3
// #0,counter=2
// #2,counter=2
// #2,counter=1
// #1,counter=2
// #0,counter=1
// #1,counter=1