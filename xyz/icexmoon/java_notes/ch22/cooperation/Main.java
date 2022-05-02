package ch22.cooperation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import ch22.cooperation.Need.Type;

class Need {
    enum Type {
        EVEN, ODD
    };

    public Type nextType = Type.EVEN;
}

class OddWriter implements Runnable {
    private Need need;
    private int num = 1;

    public OddWriter(Need need) {
        this.need = need;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (need) {
                    while (need.nextType != Need.Type.ODD) {
                        need.wait();
                    }
                    System.out.print(num + " ");
                    num += 2;
                    need.nextType = Need.Type.EVEN;
                    TimeUnit.MILLISECONDS.sleep(100);
                    need.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            // e.printStackTrace();
        }
    }
}

class EvenWriter implements Runnable {
    private Need need;
    private int num = 0;

    public EvenWriter(Need need) {
        this.need = need;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (need) {
                    while (need.nextType != Type.EVEN) {
                        need.wait();
                    }
                    System.out.print(num + " ");
                    num += 2;
                    need.nextType = Type.ODD;
                    TimeUnit.MILLISECONDS.sleep(100);
                    need.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            // e.printStackTrace();
        }

    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Need need = new Need();
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new EvenWriter(need));
        es.execute(new OddWriter(need));
        TimeUnit.SECONDS.sleep(3);
        es.shutdownNow();
    }
}
// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 