package ch6.factory3;

public class HTFactory implements Factory {
    public Tank buildTank(){
        Tank t = new HeavyTank();
        t.buildSites();
        t.buildBarbette();
        t.buildWeaponSystem();
        t.ready();
        return t;
    }
}
