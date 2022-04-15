package ch20.usecase;

import util.Fmt;

public class Student {
    private static int counter = 0;
    private final int ID = ++counter;
    private String name;
    private int age;

    public Student(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Student(Id%d,Name%s,Age%d)", ID, name, age);
    }

    public static int getTotal() {
        return counter;
    }
}
