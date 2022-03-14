package ch14.hijack_interface;

class Animal implements Comparable<Animal> {

    @Override
    public int compareTo(Animal o) {
        return 0;
    }

}

// class Cat extends Animal implements Comparable<Cat> {
// The interface Comparable cannot be implemented more than once with different
// arguments: Comparable<Animal> and Comparable<Cat>Java(16777755)

// }

public class Main {
    public static void main(String[] args) {

    }
}
