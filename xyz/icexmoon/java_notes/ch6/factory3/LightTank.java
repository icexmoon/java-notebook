package ch6.factory3;

public class LightTank implements Tank {
    public void buildSites(){
        System.out.println("Light Tank sites is build.");
    }

    public void buildBarbette(){
        System.out.println("Light Tank barbette is build.");
    }

    public void buildWeaponSystem(){
        System.out.println("Light Tank weapon system is build.");
    }

    public void ready(){
        System.out.println("Light Tank build work is all over.");
    }
}
