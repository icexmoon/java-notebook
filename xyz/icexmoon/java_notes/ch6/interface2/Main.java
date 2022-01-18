package ch6.interface2;

interface CarTestable {
    void move();

    void fire();
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

//装甲车
class ArmouredCar implements CarTestable{

    @Override
    public void move() {
        System.out.println("Armoured Car is moving.");
    }

    @Override
    public void fire() {
        System.out.println("Armoured Car is firing.");
    }}

public class Main {
    private static void test(CarTestable ct){
        ct.move();
        ct.fire();
    }
    public static void main(String[] args) {
        CarTestable ct1 = new HeavyTank();
        CarTestable ct2 = new LightTank();
        CarTestable ct3 = new ArmouredCar();
        test(ct1);
        test(ct2);
        test(ct3);
    }
}
