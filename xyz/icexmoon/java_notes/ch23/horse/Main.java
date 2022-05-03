package ch23.horse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import util.Fmt;

class Horse implements Runnable {
    private static Random rand = new Random();
    private static int counter = 0;
    private final int id = ++counter;
    private int distance; // 当前马匹跑的距离
    private CyclicBarrier cb;

    public Horse(CyclicBarrier cb) {
        this.cb = cb;
    }

    public synchronized int getDistance() {
        return distance;
    }

    public synchronized void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            setDistance(getDistance() + rand.nextInt(3) + 1);
            try {
                cb.await();
            } catch (InterruptedException e) {
                // e.printStackTrace();
            } catch (BrokenBarrierException e) {
                // e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Horse#%d", id);
    }

}

class HorseRaceingTrack implements Runnable {
    private final int length = 20; // 跑道长度
    private List<Horse> horse = new ArrayList<>();
    private CyclicBarrier cb;
    private ExecutorService es;

    private class RaceingPrinter implements Runnable {

        @Override
        public void run() {
            // 打印跑道
            for (int i = 0; i < length; i++) {
                System.out.print("=");
            }
            System.out.println();
            // 打印马匹
            boolean gameOver = false;
            for (Horse horse : horse) {
                int distance = horse.getDistance();
                for (int i = 0; i < distance; i++) {
                    System.out.print("-");
                }
                System.out.println(horse);
                if (distance >= length) {
                    gameOver = true;
                }
            }
            if (gameOver) {
                es.shutdownNow();
            } else {
                cb.reset();
            }
        }

    }

    public HorseRaceingTrack(int horseNum) {
        cb = new CyclicBarrier(horseNum, new RaceingPrinter());
        for (int i = 0; i < horseNum; i++) {
            horse.add(new Horse(cb));
        }
        es = Executors.newCachedThreadPool();
    }

    @Override
    public void run() {
        for (Horse horse : horse) {
            es.execute(horse);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        HorseRaceingTrack hrt = new HorseRaceingTrack(5);
        new Thread(hrt) {
        }.start();
    }
}
