package ch13.tuple;

import util.Fmt;

class TwoTuple<A, B> {
    public final A a;
    public final B b;

    public TwoTuple(A a, B b) {
        this.a = a;
        this.b = b;
    }
}

public class Main {
    public static void main(String[] args) {
        TwoTuple<String, Integer> student1 = new TwoTuple("Li Lei", 23);
        TwoTuple<String, Integer> student2 = new TwoTuple("Han Meimei", 20);
        printStudent(student1);
        printStudent(student2);
    }

    private static void printStudent(TwoTuple<String, Integer> student) {
        Fmt.printf("Student's name is %s, age is %d.\n", student.a, student.b);
    }
}
// Student's name is Li Lei, age is 23.
// Student's name is Han Meimei, age is 20.