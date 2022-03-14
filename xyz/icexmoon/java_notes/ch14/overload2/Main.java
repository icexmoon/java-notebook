package ch14.overload2;

interface Generator<T> {
    T next();
}

class OverloadTest<T> {
    public void f1(Generator<String> gen) {

    }

    public void f2(Generator<Integer> gen) {

    }
}

public class Main {
    public static void main(String[] args) {

    }
}
