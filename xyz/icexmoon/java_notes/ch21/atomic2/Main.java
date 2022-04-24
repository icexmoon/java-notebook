package ch21.atomic2;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class IntGenerator {
    private static volatile int num;

    public synchronized static int next() {
        return num++;
    }
}

class CircularSet {
    private int[] content;
    private int index;

    public CircularSet(int size) {
        content = new int[size];
        Arrays.fill(content, -1);
    }

    public synchronized boolean add(int num) {
        if (contains(num)) {
            return false;
        }
        content[index] = num;
        index++;
        index = index % content.length;
        return true;
    }

    public synchronized boolean contains(int num) {
        for (int i = 0; i < content.length; i++) {
            if (num == content[i]) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        final int SIZE = 1000;
        CircularSet cs = new CircularSet(SIZE);
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            es.execute(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        int num = IntGenerator.next();
                        Boolean result = cs.add(num);
                        if (!result) {
                            System.out.println(num + " is already in set.");
                            break;
                        }
                    }
                }
            });
        }
        es.shutdown();
    }
}