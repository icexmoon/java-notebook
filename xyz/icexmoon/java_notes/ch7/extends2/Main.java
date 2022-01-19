package ch7.extends2;

class OulterCls {
    class InnerCls {
    }

    class InnerChild extends InnerCls {

    }
}

public class Main {
    public static void main(String[] args) {
        OulterCls oc = new OulterCls();
        OulterCls.InnerChild ic = oc.new InnerChild();
    }
}
