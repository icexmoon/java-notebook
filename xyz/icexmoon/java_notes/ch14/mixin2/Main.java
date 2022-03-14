package ch14.mixin2;

class Base {
    private Object obj;

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Object getObj() {
        return this.obj;
    }

}

interface Counterable {
    public void count();

    public int getId();
}

class Counter implements Counterable {
    private int id = 0;
    private static int count = 0;

    @Override
    public void count() {
        id = ++count;
    }

    @Override
    public int getId() {
        return id;
    }

}

class Mixin extends Base implements Counterable {
    private Counter counter = new Counter();

    @Override
    public void count() {
        counter.count();
    }

    @Override
    public int getId() {
        return counter.getId();
    }

}

public class Main {
    public static void main(String[] args) {
        Mixin mix1,mix2;
        mix1 = new Mixin();
        mix1.count();
        mix2 = new Mixin();
        mix2.count();
        System.out.println(mix1.getId());
        System.out.println(mix2.getId());
        mix1.setObj("hello");
        System.out.println(mix1.getObj());
    }
}
