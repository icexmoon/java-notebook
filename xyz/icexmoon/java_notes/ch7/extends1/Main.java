package ch7.extends1;

class OulterCls{
    class InnerCls{}
}

class InnerChild extends OulterCls.InnerCls{

    public InnerChild(OulterCls oc) {
        oc.super();
    }

}

public class Main {
    public static void main(String[] args) {
        OulterCls oc = new OulterCls();
        InnerChild ic =  new InnerChild(oc);
    }
}
