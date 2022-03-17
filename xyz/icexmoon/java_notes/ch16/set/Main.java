package ch16.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import ch15.test2.CommonGenerator;
import ch15.test2.Generator;
import ch15.test2.RandomGenerator;
import util.Fmt;

class Student {
    protected int id = 0;
    protected String name;
    protected int age;

    public Student(String name, int age) {
        this.name = name;
        if (age <= 0) {
            age = 1;
        }
        this.age = age;
    }

    public Student(String name, int age, int id) {
        this(name, age);
        if (id <= 0) {
            id = 0;
        }
        this.id = id;
    }

    public static Generator<Student> generator() {
        return new Generator<Student>() {
            private Generator<String> nameGen = new RandomGenerator.StringGenerator();
            private Generator<Integer> ageGen = new RandomGenerator.IntGenerator(30);
            private Generator<Integer> idGen = new CommonGenerator.IntGenerator();

            @Override
            public Student next() {
                return new Student(nameGen.next(), ageGen.next(), idGen.next());
            }

            @Override
            public void reset() {
                idGen = new CommonGenerator.IntGenerator();
            }

        };
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Student(%d#%s,%d)", id, name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student other = (Student) obj;
            if (this.id == other.id) {
                return true;
            }
        }
        return false;
    }
}

class HashableStudent extends Student {

    public HashableStudent(Student student) {
        super(student.name, student.age, student.id);
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(id).hashCode();
    }

    public static Generator<Student> generator() {
        return new Generator<Student>() {
            private Generator<Student> sGen = Student.generator();

            @Override
            public Student next() {
                return new HashableStudent(sGen.next());
            }

            @Override
            public void reset() {
                sGen.reset();
            }

        };
    }

}

class ComparableStudent extends Student implements Comparable<Student> {

    public ComparableStudent(Student student) {
        super(student.name, student.age, student.id);
    }

    @Override
    public int compareTo(Student o) {
        if (equals(o)) {
            return 0;
        } else if (id < o.id) {
            return -1;
        } else {
            return 1;
        }
    }

    public static Generator<Student> generator() {
        return new Generator<Student>() {
            private Generator<Student> sGen = Student.generator();

            @Override
            public Student next() {
                return new ComparableStudent(sGen.next());
            }

            @Override
            public void reset() {
                sGen.reset();
            }

        };
    }

}

public class Main {
    public static void main(String[] args) {
        test(new HashSet<>(), HashableStudent.generator());
        test(new TreeSet<>(), ComparableStudent.generator());
        test(new LinkedHashSet<>(), HashableStudent.generator());
        test(new HashSet<>(), Student.generator());
        test(new TreeSet<>(), Student.generator());
        test(new LinkedHashSet<>(), Student.generator());
    }

    private static <E> void test(Set<E> set, Generator<E> gen) {
        System.out.println(set.getClass().getSimpleName() + " test");
        try {
            fill(set, gen);
            gen.reset();
            fill(set, gen);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(set);
    }

    private static <E> void fill(Set<E> set, Generator<E> gen) {
        for (int i = 0; i < 3; i++) {
            set.add(gen.next());
        }
    }
}
// HashSet test
// [Student(0#xiusx,8), Student(1#xpxhc,8), Student(2#rerdp,11)]
// TreeSet test
// [Student(0#zzbau,4), Student(1#ilmpr,13), Student(2#mhfwj,9)]
// LinkedHashSet test
// [Student(0#rgsyv,4), Student(1#rocon,10), Student(2#liapq,4)]
// HashSet test
// [Student(0#bfqqj,18), Student(2#unflr,24), Student(1#ltjbd,3), Student(2#mflmw,5), Student(1#bgzds,13), Student(0#qbjmt,16)]
// TreeSet test
// java.lang.ClassCastException: class ch16.set.Student cannot be cast to class java.lang.Comparable (ch16.set.Student is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
// []
// LinkedHashSet test
// [Student(0#ozork,19), Student(1#zqwsk,24), Student(2#ktcuy,6), Student(0#fvhzn,14), Student(1#sfbbu,12), 
// Student(2#eohtq,8)]