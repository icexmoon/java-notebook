package ch13.easy_tuple;

import util.Fmt;

class Tuple {
    public static <A, B> TwoTuple<A, B> tuple(A a, B b) {
        return new TwoTuple<A, B>(a, b);
    }

    public static <A, B, C> ThreeTuple<A, B, C> tuple(A a, B b, C c) {
        return new ThreeTuple(a, b, c);
    }

    public static <A, B, C, D> FourTuple<A, B, C, D> tuple(A a, B b, C c, D d) {
        return new FourTuple(a, b, c, d);
    }

    public static <A, B, C, D, E> FiveTuple<A, B, C, D, E> tuple(A a, B b, C c, D d, E e) {
        return new FiveTuple(a, b, c, d, e);
    }
}

public class Main {
    public static void main(String[] args) {
        printStudent(Tuple.tuple("Li Lei", 20));
        printStudent(Tuple.tuple("Han Meimei", 15));
    }

    private static void printStudent(TwoTuple<String, Integer> student) {
        Fmt.printf("Student's name is %s, age is %d\n", student.a, student.b);
    }
}
// Student's name is Li Lei, age is 20
// Student's name is Han Meimei, age is 15
