package ch6.abstract3;

abstract class Tank {
    abstract public void move();

    abstract public void fire();

}

class LightTank extends Tank {

    @Override
    public void move() {
        System.out.println("Light Tank is moving.");
    }

    @Override
    public void fire() {
        System.out.println("Light Tank is firing.");
    }

}

class HeavyTank extends Tank {

    @Override
    public void move() {
        System.out.println("Heavy Tank is moving.");
    }

    @Override
    public void fire() {
        System.out.println("Heavy Tank is firing.");
    }
}

public class Main {
    public static void main(String[] args) {
        Tank t1 = new HeavyTank();
        Tank t2 = new LightTank();
        t1.move();
        t1.fire();
        t2.move();
        t2.fire();
        // Heavy Tank is moving.
        // Heavy Tank is firing.
        // Light Tank is moving.
        // Light Tank is firing.
    }
}
