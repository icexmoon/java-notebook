package ch15.equal2;

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
}
