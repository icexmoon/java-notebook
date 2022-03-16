package ch15.sort3;

import java.util.Arrays;

import ch15.test2.ArrayFiller;

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[6];
        ArrayFiller.fill(students, Student.randomGenerator());
        System.out.println(Arrays.toString(students));
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
// [Student(88), Student(38), Student(84), Student(78), Student(8), Student(98)]
// [Student(8), Student(38), Student(78), Student(84), Student(88), Student(98)]