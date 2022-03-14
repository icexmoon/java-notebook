package ch14.gen_interface3;

interface Playable<T> {
    void play(T obj);
}

class Person implements Playable {

    @Override
    public void play(Object obj) {
        System.out.println("Person play " + obj);
    }
}

class Student extends Person implements Playable {
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.play("toy");
    }
}
// Person play toy
