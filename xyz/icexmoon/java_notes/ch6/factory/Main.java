package ch6.factory;

class Tank{
    public void buildSites(){
        System.out.println("Tank sites is build.");
    }

    public void buildBarbette(){
        System.out.println("Tank barbette is build.");
    }

    public void buildWeaponSystem(){
        System.out.println("Tank weapon system is build.");
    }

    public void ready(){
        System.out.println("Tank build work is all over.");
    }
}

public class Main {
    public static void main(String[] args) {
        Tank t = new Tank();
        t.buildSites();
        t.buildBarbette();
        t.buildWeaponSystem();
        t.ready();
    }
}
