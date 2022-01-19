package ch7.nonname5;

import util.Fmt;

abstract class Tank{
    protected String name;
    public Tank(String name){
        this.name = name;
    }
    abstract public void fire();
    abstract public void move();
}

class TankFactory{
    public static Tank buildTank(String name){
        return new Tank(name) {

            @Override
            public void fire() {
                Fmt.printf("Tank(%s) is firing.\n", this.name);
            }

            @Override
            public void move() {
                Fmt.printf("Tank(%s) is moving.\n", this.name);
            }
            
        };
    }
}

public class Main {
    public static void main(String[] args) {
        Tank tank = TankFactory.buildTank("99");
        tank.move();
        tank.fire();   
        // Tank(99) is moving.
        // Tank(99) is firing.
    }
}
