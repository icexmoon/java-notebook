package ch15.sort3;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import ch15.test2.Generator;
import util.Fmt;

class Student implements Comparable<Student> {
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

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        } else if (obj instanceof Student) {
            Student other = (Student) obj;
            return this.id == other.id;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Student o) {
        if (id < o.id) {
            return -1;
        } else if (id == o.id) {
            return 0;
        } else {
            return 1;
        }
    }

    public static Generator<Student> randomGenerator() {
        return new Generator<Student>() {
            private Random rand = new Random();
            private Set<Integer> ids = new HashSet<>();
            private int counter = 0;
            private final int MAX = 100;

            @Override
            public Student next() {
                if (counter >= MAX) {
                    return null;
                }
                Student student = new Student();
                int newId = 0;
                do {
                    newId = rand.nextInt(MAX);
                    if (!ids.contains(newId)) {
                        break;
                    }
                } while (true);
                student.id = newId;
                counter++;
                return student;
            }

        };
    }

}
