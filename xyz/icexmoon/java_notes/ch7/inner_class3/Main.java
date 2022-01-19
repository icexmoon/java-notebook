package ch7.inner_class3;

import java.util.Random;

import util.Fmt;

class OulterClass {
    protected class InnerClass {
        private int num;

        public InnerClass(int num) {
            this.num = num;
            System.out.println("print inner:" + this.toString());
            System.out.println("print outler:" + OulterClass.this.toString());
            // print inner:InnerClass(66)
            // print outler:OulterClass()
        }

        @Override
        public String toString() {
            return Fmt.sprintf("InnerClass(%d)", num);
        }

        public OulterClass getOulterClassInstance() {
            return OulterClass.this;
        }

    }

    public InnerClass getInnerClassInstance() {
        Random random = new Random();
        return new InnerClass(random.nextInt(100));
    }

    @Override
    public String toString() {
        return "OulterClass()";
    }

}

public class Main {
    public static void main(String[] args) {
        OulterClass oc = new OulterClass();
        OulterClass.InnerClass ic = oc.getInnerClassInstance();
        System.out.println(ic);
        // InnerClass(84)
        OulterClass oc2 = ic.getOulterClassInstance();
        System.out.println(oc == oc2);
        // true
    }
}
