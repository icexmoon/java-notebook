package ch9.set4;

import java.util.Set;
import java.util.TreeSet;

import util.Fmt;

class Student {
    private int age;
    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Student(name:%s,age:%d)", name, age);
    }
}

public class Main {

    public static void main(String[] args) {
        // class ch9.set4.Student cannot be cast to class java.lang.Comparable ...
        Set<Student> students = new TreeSet<>();
        students.add(new Student(19, "Li Lei"));
        students.add(new Student(15, "Zhang San"));
        students.add(new Student(20, "Han Meimei"));
    }
}
