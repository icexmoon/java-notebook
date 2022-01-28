package ch11.tostring2;

class MyCls {
    @Override
    public String toString() {
        return "MyCls's string:" + this;
    }
}

public class Main {
    public static void main(String[] args) {
        MyCls mc = new MyCls();
        System.out.println(mc);
    }
}
// at java.base/java.lang.String.valueOf(String.java:3365)
// at java.base/java.lang.StringBuilder.append(StringBuilder.java:169)
// at ch11.tostring2.MyCls.toString(Main.java:6)
// at java.base/java.lang.String.valueOf(String.java:3365)
// at java.base/java.lang.StringBuilder.append(StringBuilder.java:169)
// at ch11.tostring2.MyCls.toString(Main.java:6)
