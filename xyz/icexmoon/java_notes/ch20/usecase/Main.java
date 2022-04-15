package ch20.usecase;

public class Main {
    public static void main(String[] args) {
        ClassRoom cr = new ClassRoom(1, 1);
        cr.addStudent(new Student("Li lei", 15));
        cr.addStudent(new Student("Han Meimei", 10));
        cr.addStudent(new Student("Brus Lee", 20));
        System.out.println(cr);
    }
}
