package ch12.generic2;

class MyCls{}

public class Main {
    public static void main(String[] args) {
        Class<?> cls = MyCls.class;
        cls = Object.class;
        cls = int.class;
    }
}
