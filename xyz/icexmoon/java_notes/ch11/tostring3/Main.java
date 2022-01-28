package ch11.tostring3;

class MyCls {
    @Override
    public String toString() {
        return "MyCls's string:" + super.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        MyCls mc = new MyCls();
        System.out.println(mc);
        // MyCls's string:ch11.tostring3.MyCls@24d46ca6
    }
}
