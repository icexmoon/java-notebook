package ch16.ref2;

import java.util.LinkedList;
import java.util.List;
import java.util.WeakHashMap;

import util.Fmt;

class Student {
    private static int counter = 0;
    private int id = ++counter;

    @Override
    public String toString() {
        return Fmt.sprintf("Student(%d)", id);
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(id).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            if (this.id == ((Student) obj).id) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        WeakHashMap<Student, Integer> whm = new WeakHashMap<>();
        List<Student> students = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Student s = new Student();
            if (i > 5) {
                students.add(s);
            }
            Integer num = Integer.valueOf(i);
            whm.put(s, num);
        }
        System.out.println(whm);
        System.gc();
        System.out.println(students);
        System.out.println(whm);
    }
}
// {Student(10)=9, Student(9)=8, Student(8)=7, Student(7)=6, Student(6)=5, Student(5)=4, Student(4)=3, Student(3)=2, Student(2)=1, Student(1)=0}
// [Student(7), Student(8), Student(9), Student(10)]
// {Student(10)=9, Student(9)=8, Student(8)=7, Student(7)=6}
