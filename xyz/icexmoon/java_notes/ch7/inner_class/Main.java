package ch7.inner_class;

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

    }

    public InnerClass getInnerClassInstance() {
        Random random = new Random();
        return new InnerClass(random.nextInt(100));
    }
}

public class Main {
    public static void main(String[] args) {
        OulterClass oc = new OulterClass();
        OulterClass.InnerClass ic = oc.getInnerClassInstance();
        System.out.println(ic);
        // InnerClass(84)
    }
}
