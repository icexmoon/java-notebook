package ch7.factory3;

public class HeavyTank implements Tank {
    public static Factory factory = new Factory() {

        @Override
        public Tank buildTank() {
            HeavyTank tank = new HeavyTank();
            tank.buildSites();
            tank.buildBarbette();
            tank.buildWeaponSystem();
            tank.ready();
            return tank;
        }
        
    };

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
