package ch7.override2;

class ParentOulter {
    public class Inner {
        public Inner() {
            System.out.println("ParentOulter.Inner is build.");
        }

        @Override
        public String toString() {
            return "ParentOulter.Inner";
        }
    }

    public Inner getInnerInstance() {
        return new Inner();
    }
}

class ChildOulter extends ParentOulter {
    public class Inner extends ParentOulter.Inner {
        public Inner() {
            super();
            System.out.println("ChildOulter.Inner is build.");
        }

        @Override
        public String toString() {
            return "ChildOulter.Inner";
        }
    }

    @Override
    public ParentOulter.Inner getInnerInstance() {
        return new Inner();
    }

}

public class Main {
    public static void main(String[] args) {
        ChildOulter co = new ChildOulter();
        System.out.println(co.getInnerInstance());
        // ParentOulter.Inner is build.
        // ChildOulter.Inner is build.
        // ChildOulter.Inner
    }
}
