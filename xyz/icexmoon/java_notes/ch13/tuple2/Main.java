package ch13.tuple2;

import util.Fmt;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static TwoTuple<Student, Boolean> getNewStudent() {
        return new TwoTuple(new Student("none", 0), true);
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Student's name is %s, age is %d.\n", name, age);
    }
}

public class Main {
    public static void main(String[] args) {
        TwoTuple<Student, Boolean> result = Student.getNewStudent();
        if (result.b) {
            System.out.println(result.a);
        }
    }
}
// Student's name is none, age is 0.