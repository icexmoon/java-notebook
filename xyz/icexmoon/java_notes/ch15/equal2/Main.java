package ch15.equal2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student[] students1 = new Student[5];
        Student[] students2 = new Student[5];
        Arrays.fill(students1, new Student());
        Arrays.fill(students2, new Student());
        System.out.println(Arrays.equals(students1, students2));
        students1[0].setId(99);
        students2[0].setId(99);
        System.out.println(Arrays.equals(students1, students2));
    }
}
// false
// true
