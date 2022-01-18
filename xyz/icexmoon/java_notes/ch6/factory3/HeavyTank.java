package ch6.factory3;

public class HeavyTank implements Tank {
    public void buildSites(){
        System.out.println("Heavy Tank sites is build.");
    }

    public void buildBarbette(){
        System.out.println("Heavy Tank barbette is build.");
    }

    public void buildWeaponSystem(){
        System.out.println("Heavy Tank weapon system is build.");
    }

    public void ready(){
        System.out.println("Heavy Tank build work is all over.");
    }
}
