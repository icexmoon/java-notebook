package ch14.self_bounded4;

class Person<T extends Person<T>>{
    public void play(T person){
        System.out.println("Person play with Person.");
    }
}

class Student extends Person<Student>{
    @Override
    public void play(Student student) {
        System.out.println("Student play with Student.");
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.play(new Student());
        // s.play(new Person());
        // The method play(Student) in the type Student is not applicable for the arguments (Person)
    }
}
