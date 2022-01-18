package ch6.factory2;

public class Tank {
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
