package ch6.interface4;

interface CarTestable {
    void move();

    default void fire(){
        System.out.println("Skip fire test.");
    };

    static void test(CarTestable ct) {
        ct.move();
        ct.fire();
    }
}

abstract class Tank implements CarTestable {
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

// 装甲车
class ArmouredCar implements CarTestable {

    @Override
    public void move() {
        System.out.println("Armoured Car is moving.");
    }

    @Override
    public void fire() {
        System.out.println("Armoured Car is firing.");
    }
}

class Jeep implements CarTestable{

    @Override
    public void move() {
        System.out.println("Jeep is moving.");
    }}

public class Main {

    public static void main(String[] args) {
        CarTestable ct1 = new HeavyTank();
        CarTestable ct2 = new LightTank();
        CarTestable ct3 = new ArmouredCar();
        CarTestable.test(ct1);
        CarTestable.test(ct2);
        CarTestable.test(ct3);
        CarTestable ct4 = new Jeep();
        CarTestable.test(ct4);
        // Jeep is moving.
        // Skip fire test.
    }
}
