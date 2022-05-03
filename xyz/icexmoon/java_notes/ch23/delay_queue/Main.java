package ch23.delay_queue;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import util.Fmt;

class DelayedTask implements Runnable, Delayed {
    private static int counter = 0;
    private final int id = ++counter;
    private int delayed; // 推迟的毫秒数
    private long trigger;

    public DelayedTask(int delayed) {
        this.delayed = delayed;
        trigger = delayed + System.currentTimeMillis();
    }

    @Override
    public void run() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return Fmt.sprintf("task#%d(%dms)", id, delayed);
    }

    @Override
    public int compareTo(Delayed o) {
        DelayedTask other = (DelayedTask) o;
        if (delayed > other.delayed) {
            return 1;
        } else if (delayed < other.delayed) {
            return -1;
        }
        return 0;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

}

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        DelayQueue<DelayedTask> dq = new DelayQueue<>();
        final int SIZE = 10;
        for (int i = 0; i < SIZE; i++) {
            dq.add(new DelayedTask(random.nextInt(10000)));
        }
        int counter = 0;
        do {
            try {
                dq.take().run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
            if (counter >= SIZE) {
                break;
            }
        } while (true);
    }
}
// task#4(1167ms)
// task#8(1488ms)
// task#5(2531ms)
// task#9(2670ms)
// task#10(2969ms)
// task#6(3337ms)
// task#7(4334ms)
// task#1(4503ms)
// task#2(5532ms)
// task#3(8136ms)