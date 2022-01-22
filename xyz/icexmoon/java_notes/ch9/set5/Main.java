package ch9.set5;

import java.util.Set;
import java.util.TreeSet;

import util.Fmt;

class Student implements Comparable<Student> {
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

    @Override
    public int compareTo(Student s) {
        return Integer.compare(this.age, s.age);
    }
}

public class Main {

    public static void main(String[] args) {
        Set<Student> students = new TreeSet<>();
        students.add(new Student(19, "Li Lei"));
        students.add(new Student(15, "Zhang San"));
        students.add(new Student(20, "Han Meimei"));
        for (Student s : students) {
            System.out.print(s + " ");
        }
        System.out.println();
        // Student(name:Zhang San,age:15) Student(name:Li Lei,age:19) Student(name:Han
        // Meimei,age:20)
    }
}
