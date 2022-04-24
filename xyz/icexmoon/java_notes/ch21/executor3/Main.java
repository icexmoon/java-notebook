package ch21.executor3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Fibnacci {
    public static int fibnacci(int n) {
        if (n <= 2) {
            return 1;
        }
        return fibnacci(n - 1) + fibnacci(n - 2);
    }
}

class FibnacciTask implements Callable<Integer> {
    private int n;

    public FibnacciTask(int n) {
        this.n = n;
    }

    @Override
    public Integer call() throws Exception {
        return Fibnacci.fibnacci(n);
    }

}

public class Main {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        List<Future<Integer>> results = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            Future<Integer> result = es.submit(new FibnacciTask(i));
            results.add(result);
        }
        for (Future<Integer> result : results) {
            try {
                System.out.print(result.get() + " ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
// 1 1 2 3 5 8 13 21 34 55 