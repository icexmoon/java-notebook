package ch21.share_data2;

class Bank {
    private int money;

    synchronized public int saveMoney(int amount) {
        money += amount;
        return money;
    }

    synchronized public int getMoney(int amount) {
        if (money - amount < 0) {
            System.out.println("money is not enough.");
        }
        money -= amount;
        return money;
    }

    synchronized public int showMoney() {
        return money;
    }
}

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            testBank(new Bank());
        }
    }

    private static void testBank(Bank bank) {
        Thread t1, t2;
        t1 = new Thread() {
            public void run() {
                bank.saveMoney(100);
                System.out.println("bank amount:" + bank.showMoney());
            };
        };
        t2 = new Thread() {
            public void run() {
                bank.saveMoney(200);
            };
        };
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
// bank amount:300
// bank amount:100
// bank amount:300
// bank amount:300
// bank amount:300
// bank amount:100
// bank amount:300
// bank amount:300
// bank amount:300
// bank amount:300