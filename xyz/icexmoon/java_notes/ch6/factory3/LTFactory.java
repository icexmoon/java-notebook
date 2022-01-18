package ch6.factory3;

public class LTFactory implements Factory {
    public Tank buildTank(){
        Tank t = new LightTank();
        t.buildSites();
        t.buildBarbette();
        t.buildWeaponSystem();
        t.ready();
        return t;
    }
}
