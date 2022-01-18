package ch6.factory2;

public class Factory {
    public static Tank buildTank(){
        Tank t = new Tank();
        t.buildSites();
        t.buildBarbette();
        t.buildWeaponSystem();
        t.ready();
        return t;
    }
}
