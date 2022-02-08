package ch12.null_object2;

class Room {
    private String number = "";
    private Student[] beds = new Student[4];
    {
        for (int i = 0; i < beds.length; i++) {
            beds[i] = Student.NULL;
        }
    }

    public Room(String number) {
        this.number = number;
    }

    public boolean addStudent(Student student) {
        for (int i = 0; i < beds.length; i++) {
            if (beds[i] == Student.NULL) {
                beds[i] = student;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(number);
        sb.append("[");
        String splite = ", ";
        for (Student student : beds) {
            sb.append(student.getName());
            sb.append(splite);
        }
        sb.delete(sb.length() - splite.length(), sb.length());
        sb.append("]");
        return sb.toString();
    }
}

class Student {
    private String name;
    public static final Student NULL = new Student("empty");

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        Room room = new Room("404");
        room.addStudent(new Student("Li Lei"));
        System.out.println(room);
    }
}
// 404[Li Lei, empty, empty, empty]