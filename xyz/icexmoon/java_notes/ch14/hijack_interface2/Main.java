package ch14.hijack_interface2;

class Animal implements Comparable<Animal> {

    @Override
    public int compareTo(Animal o) {
        return 0;
    }

}

class Cat extends Animal implements Comparable<Animal> {

}

public class Main {
    public static void main(String[] args) {

    }
}
