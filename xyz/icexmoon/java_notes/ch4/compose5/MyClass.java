package ch4.compose5;

class Compose {
}

public class MyClass {
    private Compose compose;

    public MyClass() {
    }

    public Compose getCompose() {
        if (compose == null) {
            compose = new Compose();
        }
        return compose;
    }

    public static void main(String[] args) {

    }
}
