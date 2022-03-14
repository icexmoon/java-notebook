package ch14.self_bounded2;

class Person<T extends Person<T>>{
    public void play(T person){
        System.out.println("Person play with Person.");
    }
}

class Student extends Person<Student>{
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.play(new Student());
    }
}
