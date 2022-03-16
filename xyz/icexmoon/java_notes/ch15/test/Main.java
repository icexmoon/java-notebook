package ch15.test;

import java.util.Arrays;

import util.Fmt;

class Student {
    private static int counter = 0;
    private int id = ++counter;

    @Override
    public String toString() {
        return Fmt.sprintf("Student(%d)", id);
    }

    public void set(int id) {
        this.id = id;
    }
}

public class Main {
    public static void main(String[] args) {
        final int SIZE = 5;
        int[] arr = new int[SIZE];
        Arrays.fill(arr, 99);
        System.out.println(Arrays.toString(arr));
        Student[] students = new Student[SIZE];
        Student defaultStudent = new Student();
        Arrays.fill(students, defaultStudent);
        System.out.println(Arrays.toString(students));
        defaultStudent.set(99);
        System.out.println(Arrays.toString(students));
        Student newStudent = new Student();
        newStudent.set(50);
        Arrays.fill(students, 1, 3, newStudent);
        System.out.println(Arrays.toString(students));
    }

}
// [99, 99, 99, 99, 99]
// [Student(1), Student(1), Student(1), Student(1), Student(1)]
// [Student(99), Student(99), Student(99), Student(99), Student(99)]
// [Student(99), Student(50), Student(50), Student(99), Student(99)]