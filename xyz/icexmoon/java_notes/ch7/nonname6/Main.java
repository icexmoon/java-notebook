package ch7.nonname6;

import util.Fmt;

abstract class Tank {
    protected String name;

    public Tank(String name) {
        this.name = name;
    }

    abstract public void fire();

    abstract public void move();
}

class TankFactory {
    private static int num = 1;

    public static Tank buildTank(String name) {
        final int newNum = num;
        num++;
        return new Tank(name) {
            private int num;
            {
                this.num = newNum;
                Fmt.printf("Tank(name:%s,num:%d) is build.\n", this.name, this.num);
            }

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
        Tank t1 = TankFactory.buildTank("99");
        Tank t2 = TankFactory.buildTank("M1A1");
        // Tank(name:99,num:1) is build.
        // Tank(name:M1A1,num:2) is build.
    }
}
