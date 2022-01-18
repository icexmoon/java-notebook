package ch6.factory3;

public class Main {
    public static void main(String[] args) {
        Factory factory = new HTFactory();
        Tank tank1 = factory.buildTank();
        factory = new LTFactory();
        Tank tank2 = factory.buildTank();
        // Heavy Tank sites is build.
        // Heavy Tank barbette is build.
        // Heavy Tank weapon system is build.
        // Heavy Tank build work is all over.
        // Light Tank sites is build.
        // Light Tank barbette is build.
        // Light Tank weapon system is build.
        // Light Tank build work is all over.
    }
}
