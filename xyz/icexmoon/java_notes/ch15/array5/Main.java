package ch15.array5;

import java.util.Arrays;

import util.Fmt;

class Student {
    private static int counter = 0;
    private final int id = ++counter;

    @Override
    public String toString() {
        return Fmt.sprintf("Student(%d)", id);
    }
}

public class Main {
    public static void main(String[] args) {
        final int SIZE = 5;
        int[] intArr = new int[SIZE];
        char[] charArr = new char[SIZE];
        Student[] students = new Student[SIZE];
        System.out.println(Arrays.toString(intArr));
        System.out.println(Arrays.toString(charArr));
        System.out.println(Arrays.toString(students));
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
        }
        System.out.println(Arrays.toString(students));
    }
}
// [0, 0, 0, 0, 0]
// [, , , , ]
// [null, null, null, null, null]
// [Student(1), Student(2), Student(3), Student(4), Student(5)]
