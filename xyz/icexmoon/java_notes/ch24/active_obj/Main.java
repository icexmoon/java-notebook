package ch24.active_obj;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class ActiveObject {
    private ExecutorService es = Executors.newSingleThreadExecutor();
    private static Random rand = new Random();

    public Future<Integer> add(int x, int y) {
        return es.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(100) + 100);
                return x + y;
            }
        });
    }

    public void shutdown() {
        es.shutdown();
    }
}

public class Main {
    public static void main(String[] args) {
        ActiveObject ao = new ActiveObject();
        List<Future<Integer>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(ao.add(i, i));
        }
        for (Future<Integer> future : results) {
            try {
                Integer integer = future.get();
                System.out.print(integer + " ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        ao.shutdown();
    }
}
// 0 2 4 6 8 10 12 14 16 18 
