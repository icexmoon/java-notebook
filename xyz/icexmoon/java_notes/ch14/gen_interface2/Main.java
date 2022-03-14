package ch14.gen_interface2;

interface Playable<T> {
    void play(T obj);
}

class Person implements Playable<String> {

    @Override
    public void play(String obj) {
        System.out.println("Person play " + obj);
    }
}

// class Student extends Person implements Playable<Integer> {
    // The interface Playable cannot be implemented more than once with different
    // arguments: Playable<String> and Playable<Integer>Java(16777755)
// }

public class Main {
    public static void main(String[] args) {

    }
}
