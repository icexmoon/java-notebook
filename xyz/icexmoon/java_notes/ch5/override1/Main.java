package ch5.override1;

class Tank {
    @Override
    public String toString() {
        return "Tank()";
    }
}

class LightTank extends Tank {
    @Override
    public String toString() {
        return "LightTank()";
    }
}

class TankFactory {
    public Tank constructTank() {
        return new Tank();
    }
}

class LightTankFactory extends TankFactory {
    @Override
    public LightTank constructTank() {
        return new LightTank();
    }
}

public class Main {
    public static void main(String[] args) {
        TankFactory tf1 = new TankFactory();
        TankFactory tf2 = new LightTankFactory();
        System.out.println(tf1.constructTank());
        System.out.println(tf2.constructTank());
        // Tank()
        // LightTank()
    }
}
