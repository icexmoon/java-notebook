package ch12.use_cls5;

class MyCls{}

public class Main {
    public static void main(String[] args) {
        Object o = new MyCls();
        MyCls myCls = MyCls.class.cast(o);
        MyCls myCls2 = (MyCls)o;
    }
}
