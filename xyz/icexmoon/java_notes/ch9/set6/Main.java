package ch9.set6;

import java.util.Comparator;
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

    public static Comparator<Student> comparator() {
        return new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.age, o2.age);
            }

        };
    }
}

public class Main {

    public static void main(String[] args) {
        Set<Student> students = new TreeSet<>(Student.comparator());
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
