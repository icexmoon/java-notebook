package ex1.hash_code;

class Student {
    private static int counter = 0;
    private int id = ++counter;
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        final int INIT_CODE = 17;
        final int MULTIPLES = 37;
        int code = INIT_CODE;
        code = code * MULTIPLES + HashCode.hash(id);
        code = code * MULTIPLES + HashCode.hash(name);
        code = code * MULTIPLES + HashCode.hash(age);
        return code;
    }

    public int hashCode2() {
        return HashCode.hash(id) ^ HashCode.hash(name) ^ HashCode.hash(age);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Li lei", 22);
        Student s2 = new Student("Han Meimei", 15);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1.hashCode2());
        System.out.println(s2.hashCode2());
    }
}
// -1766199299
// -1058088827