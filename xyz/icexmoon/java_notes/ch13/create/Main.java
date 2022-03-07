package ch13.create;

interface Factory<T> {
    public T create();
}

class GenericClass<T> {
    private T instance;

    public <F extends Factory<T>> GenericClass(F factory) {
        instance = factory.create();
    }

    public T getInstance() {
        return instance;
    }
}

class Student {
    public static class StudentFactory implements Factory<Student> {

        @Override
        public Student create() {
            return new Student();
        }

    }
    @Override
    public String toString() {
        return "Student";
    }
}

public class Main {
    public static void main(String[] args) {
        GenericClass<String> gc = new GenericClass<>(new Factory<String>() {

            @Override
            public String create() {
                return "hello";
            }

        });
        GenericClass<Student> gc2 = new GenericClass<>(new Student.StudentFactory());
        System.out.println(gc.getInstance());
        System.out.println(gc2.getInstance());
    }
}
// hello
// Student