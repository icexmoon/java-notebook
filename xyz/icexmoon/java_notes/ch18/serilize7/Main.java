package ch18.serilize7;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

class Student implements Serializable {
    private ClassRoom classRoom;
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    @Override
    public String toString() {
        return super.toString() + "-" + classRoom.toString();
    }
}

class ClassRoom implements Serializable {
    public void addStudent(Student student) {
        student.setClassRoom(this);
    }
}

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClassRoom cr = new ClassRoom();
        Student s1 = new Student("Li Lei");
        Student s2 = new Student("Han Meimei");
        Student s3 = new Student("Brus Lee");
        cr.addStudent(s1);
        cr.addStudent(s2);
        cr.addStudent(s3);
        List<Student> students = new LinkedList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        System.out.println(students);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        ByteArrayOutputStream bos2 = new ByteArrayOutputStream();
        ObjectOutputStream oos2 = new ObjectOutputStream(bos2);
        oos.writeObject(s1);
        oos.writeObject(s2);
        oos.writeObject(s3);
        oos2.writeObject(students);
        oos.flush();
        oos2.flush();
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        ObjectInputStream ois2 = new ObjectInputStream(new ByteArrayInputStream(bos2.toByteArray()));
        Student s4 = (Student) ois.readObject();
        Student s5 = (Student) ois.readObject();
        Student s6 = (Student) ois.readObject();
        List<Student> students2 = (List<Student>) ois2.readObject();
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(students2);
    }
}
// [ch18.serilize7.Student@372f7a8d-ch18.serilize7.ClassRoom@2f92e0f4,
// ch18.serilize7.Student@28a418fc-ch18.serilize7.ClassRoom@2f92e0f4,
// ch18.serilize7.Student@5305068a-ch18.serilize7.ClassRoom@2f92e0f4]
// ch18.serilize7.Student@5cb0d902-ch18.serilize7.ClassRoom@46fbb2c1
// ch18.serilize7.Student@1698c449-ch18.serilize7.ClassRoom@46fbb2c1
// ch18.serilize7.Student@5ef04b5-ch18.serilize7.ClassRoom@46fbb2c1
// [ch18.serilize7.Student@5f4da5c3-ch18.serilize7.ClassRoom@443b7951,
// ch18.serilize7.Student@14514713-ch18.serilize7.ClassRoom@443b7951,
// ch18.serilize7.Student@69663380-ch18.serilize7.ClassRoom@443b7951]