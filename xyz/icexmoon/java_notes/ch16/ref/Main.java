package ch16.ref;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import util.Fmt;

class Student {
    private static int counter = 0;
    private int id = ++counter;

    @Override
    public String toString() {
        return Fmt.sprintf("Student(%d)", id);
    }
}

public class Main {
    public static void main(String[] args) {
        final int SIZE = 10;
        List<WeakReference<Student>> list = new LinkedList<>();
        List<Student> students = new LinkedList<>();
        for (int i = 0; i < SIZE; i++) {
            Student s = new Student();
            students.add(s);
            list.add(new WeakReference<Student>(s));
        }
        System.out.println("init list=================");
        System.out.println(students);
        printWeakList(list);
        Iterator<Student> iterator = students.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            iterator.next();
            if (index % 2 == 0) {
                iterator.remove();
            }
            index++;
        }
        System.out.println("items deleted=============");
        System.out.println(students);
        printWeakList(list);
        System.gc();
        System.out.println("gc is executed============");
        printWeakList(list);
    }

    private static <T> void printWeakList(List<WeakReference<T>> list) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (WeakReference<T> wf : list) {
            T obj = wf.get();
            if (obj == null) {
                sb.append("null");
            } else {
                sb.append(obj.toString());
            }
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        String str = sb.toString();
        System.out.println(str);
    }
}
// init list===============
// [Student(1), Student(2), Student(3), Student(4), Student(5), Student(6), Student(7), Student(8), Student(9), Student(10)]
// [Student(1), Student(2), Student(3), Student(4), Student(5), Student(6), Student(7), Student(8), Student(9), Student(10)]
// items deleted=============
// [Student(2), Student(4), Student(6), Student(8), Student(10)]
// [Student(1), Student(2), Student(3), Student(4), Student(5), Student(6), Student(7), Student(8), Student(9), Student(10)]
// gc is executed============
// [null, Student(2), null, Student(4), null, Student(6), null, Student(8), null, Student(10)]