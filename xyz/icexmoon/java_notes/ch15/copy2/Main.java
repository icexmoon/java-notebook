package ch15.copy2;

import java.util.Arrays;

import ch15.test2.ArrayFiller;
import ch15.test2.Generator;
import util.Fmt;

class Student {
    private static int counter = 0;
    private int id = ++counter;

    @Override
    public String toString() {
        return Fmt.sprintf("Student(%d)", id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Generator<Student> generator() {
        return new Generator<>() {

            @Override
            public Student next() {
                return new Student();
            }

        };
    }
}

public class Main {
    public static void main(String[] args) {
        final String PREFIX1 = "students1: ";
        final String PREFIX2 = "students2: ";
        Student[] students1 = new Student[7];
        Student[] studetns2 = new Student[5];
        ArrayFiller.fill(students1, Student.generator());
        Arrays.fill(studetns2, new Student());
        System.out.println(PREFIX1 + Arrays.toString(students1));
        System.out.println(PREFIX2 + Arrays.toString(studetns2));
        System.arraycopy(studetns2, 0, students1, 0, studetns2.length);
        System.out.println(PREFIX1 + Arrays.toString(students1));
        studetns2[0].setId(99);
        System.out.println(PREFIX1 + Arrays.toString(students1));
        System.out.println(PREFIX2 + Arrays.toString(studetns2));
    }
}
// students1: [Student(1), Student(2), Student(3), Student(4), Student(5), Student(6), Student(7)]
// students2: [Student(8), Student(8), Student(8), Student(8), Student(8)]
// students1: [Student(8), Student(8), Student(8), Student(8), Student(8), Student(6), Student(7)]
// students1: [Student(99), Student(99), Student(99), Student(99), Student(99), Student(6), Student(7)]     
// students2: [Student(99), Student(99), Student(99), Student(99), Student(99)]