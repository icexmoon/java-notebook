package ch14.gen_interface;

interface Playable<T> {
    void play(T obj);
}

// class Person implements Playable<String>, Playable<Integer> {
    // The interface Playable cannot be implemented more than once with different
    // arguments: Playable<Integer> and Playable<String>
// }

public class Main {
    public static void main(String[] args) {

    }
}
