package ch21.runnable1;

import util.Fmt;

class SimpleTask implements Runnable {
    private final int id;
    private int counter = 5;

    public SimpleTask(int id) {
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
            Thread thread = new Thread(new SimpleTask(i));
            thread.start();
        }
    }
}
// #2,counter=5
// #0,counter=5
// #1,counter=5
// #2,counter=4
// #1,counter=4
// #0,counter=4
// #1,counter=3
// #1,counter=2
// #2,counter=3
// #0,counter=3
// #1,counter=1
// #2,counter=2
// #0,counter=2
// #2,counter=1
// #0,counter=1