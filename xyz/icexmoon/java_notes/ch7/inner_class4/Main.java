package ch7.inner_class4;

import java.util.Random;

import util.Fmt;

class OulterClass {
    protected class InnerClass {
        private int num;

        public InnerClass(int num) {
            this.num = num;
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
        OulterClass.InnerClass ic = oc.new InnerClass(10);
        System.out.println(ic);
        // InnerClass(10)
    }
}
