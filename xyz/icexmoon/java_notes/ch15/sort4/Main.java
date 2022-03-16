package ch15.sort4;

import java.util.Arrays;

import ch15.test2.ArrayFiller;

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[6];
        ArrayFiller.fill(students, Student.randomGenerator());
        System.out.println(Arrays.toString(students));
        Arrays.sort(students, Student.comparator());
        System.out.println(Arrays.toString(students));
    }
}
// [Student(64), Student(16), Student(49), Student(30), Student(4), Student(91)]
// [Student(91), Student(64), Student(49), Student(30), Student(16), Student(4)]