package ch21.sync_other;

class ShareData {
    public synchronized void func1() {
        for (int i = 0; i < 5; i++) {
            System.out.println("func1() is called.");
            Thread.yield();
        }
    }

    public void func2() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println("func2() is called.");
                Thread.yield();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread() {
            public void run() {
                shareData.func1();
            };
        }.start();
        new Thread() {
            public void run() {
                shareData.func2();
            };
        }.start();
    }
}
// func1() is called.
// func1() is called.
// func1() is called.
// func1() is called.
// func1() is called.
// func2() is called.
// func2() is called.
// func2() is called.
// func2() is called.
// func2() is called.