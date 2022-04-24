package ch21.share_data5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ShareData {
    private int data;

    synchronized public int increase() {
        data++;
        data++;
        return getData();
    }

    synchronized public int getData() {
        return data;
    }
}

public class Main {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        ShareData shareData = new ShareData();
        for (int i = 0; i < 10; i++) {
            es.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.print(shareData.increase() + " ");
                }
            });
        }
        es.shutdown();
    }
}
