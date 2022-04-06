package ch18.static3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import util.Fmt;

class Student implements Serializable {
    public static int counter = 0;
    private final int id = ++counter;
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Student(%d.%s)", id, name);
    }

    private void writeObject(ObjectOutputStream out)
            throws IOException {
        out.defaultWriteObject();
        out.writeInt(counter);
    }

    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        counter = in.readInt();
    }

}

public class Main {
    private static String CURRENT_DIR = "./xyz/icexmoon/java_notes/ch18/static3/";
    private static String FILE = CURRENT_DIR + "data.out";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File(FILE);
        if (file.exists()) {
            read();
            file.delete();
        } else {
            write();
        }
    }

    private static void write() throws IOException {
        Student s1 = new Student("Han Meimei");
        Student s2 = new Student("Li Lei");
        Student s3 = new Student("Brus Lee");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(FILE));
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(s1);
        oos.writeObject(s2);
        oos.writeObject(s3);
        oos.close();
    }

    private static void read() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(FILE)));
        Student s4 = (Student) ois.readObject();
        Student s5 = (Student) ois.readObject();
        Student s6 = (Student) ois.readObject();
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(Student.counter);
        ois.close();
    }
}
// Student(1.Han Meimei)
// Student(2.Li Lei)
// Student(3.Brus Lee)
// 3