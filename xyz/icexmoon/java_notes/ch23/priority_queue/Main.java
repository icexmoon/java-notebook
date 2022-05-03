package ch23.priority_queue;

import java.util.PriorityQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ch15.test2.RandomGenerator.StringGenerator;
import ch23.priority_queue.Msg.Priority;
import util.Enums;
import util.Fmt;

class Msg implements Comparable<Msg> {
    public enum Priority {
        HIGH, MEDDLE, LOW
    }

    private Priority p;
    private String message;

    public Msg(Priority p, String message) {
        this.p = p;
        this.message = message;
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Msg(%s,%s)", p, message);
    }

    @Override
    public int compareTo(Msg o) {
        return this.p.compareTo(o.p);
    }
}

class MsgWriter implements Runnable {
    private PriorityQueue<Msg> pq;
    private StringGenerator sg;
    private CountDownLatch cdl;

    public MsgWriter(PriorityQueue<Msg> pq, CountDownLatch cdl) {
        this.pq = pq;
        this.sg = new StringGenerator();
        this.cdl = cdl;
    }

    @Override
    public void run() {
        Priority p = Enums.random(Msg.Priority.class);
        pq.add(new Msg(p, sg.next()));
        cdl.countDown();
    }

}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int SIZE = 10;
        ExecutorService es = Executors.newCachedThreadPool();
        PriorityQueue<Msg> pq = new PriorityQueue<>();
        CountDownLatch cdl = new CountDownLatch(SIZE);
        for (int i = 0; i < SIZE; i++) {
            es.execute(new MsgWriter(pq, cdl));
        }
        cdl.await();
        es.shutdown();
        do {
            Msg msg = pq.poll();
            if (msg == null) {
                break;
            }
            System.out.print(msg + " ");
        } while (true);
    }
}
// Msg(HIGH,xvnrf) Msg(HIGH,byouk) Msg(HIGH,eyxse) Msg(HIGH,timmp)
// Msg(MEDDLE,olrto) Msg(LOW,dchge) Msg(LOW,nixcq)