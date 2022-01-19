package ch7.override1;

class ParentOulter {
    public class Inner {
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
    public class Inner {
        @Override
        public String toString() {
            return "ChildOulter.Inner";
        }
    }

}

public class Main {
    public static void main(String[] args) {
        ChildOulter co = new ChildOulter();
        System.out.println(co.getInnerInstance());
        // ParentOulter.Inner
    }
}
