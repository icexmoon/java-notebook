package ch14.overload;

interface Generator<T> {
    T next();
}

class OverloadTest<T> {
    // public void f(Generator<String> gen) {
    // // Erasure of method f(Generator<String>) is the same as another method in
    // type
    // // OverloadTest<T>Java(16777743)

    // }

    // public void f(Generator<Integer> gen) {

    // }
}

public class Main {
    public static void main(String[] args) {

    }
}
