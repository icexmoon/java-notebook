package ch14.self_bounded3;

class Person<T extends Person<T>> {
    public void play(T person) {
        System.out.println("Person play with Person.");
    }
}

class Student extends Person<Student> {
}

// class Teacher extends Person<String> {
// Bound mismatch: The type String is not a valid substitute for the bounded
// parameter <T extends Person<T>> of the type Person<T>Java(16777742)

// }

class Coder extends Person<Student> {
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.play(new Student());
    }
}
