package ch12.null_object3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class Room {
    private String number = "";
    private NameAble[] beds = new NameAble[4];
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
            if (beds[i] instanceof NULL) {
                beds[i] = student;
                return true;
            }
        }
        return false;
    }

    public boolean setStudent(int index, NameAble student) {
        NameAble bed = beds[index];
        if (bed instanceof NULL) {
            beds[index] = student;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(number);
        sb.append("[");
        String splite = ", ";
        for (NameAble bed : beds) {
            sb.append(bed.getName());
            sb.append(splite);
        }
        sb.delete(sb.length() - splite.length(), sb.length());
        sb.append("]");
        return sb.toString();
    }
}

interface NameAble {
    public String getName();
}

interface NULL {
}

class Student implements NameAble {
    private String name;
    public static final NameAble NULL = getNullStudent(Student.class);

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static NameAble getNullStudent(Class<?> type) {
        return (NameAble) Proxy.newProxyInstance(type.getClassLoader(), new Class<?>[] { NameAble.class, NULL.class },
                new StudentInvocationHandler(type));
    }
}

class GoodStudent extends Student {
    public static final NameAble NULL = getNullStudent(GoodStudent.class);

    public GoodStudent(String name) {
        super(name);
    }
}

class BadStudent extends Student {
    public static final NameAble NULL = getNullStudent(BadStudent.class);

    public BadStudent(String name) {
        super(name);
    }
}

class NormalStudetn extends Student {
    public static final NameAble NULL = getNullStudent(NormalStudetn.class);

    public NormalStudetn(String name) {
        super(name);
    }
}

class StudentInvocationHandler implements InvocationHandler {
    private Class<?> type;

    public StudentInvocationHandler(Class<?> type) {
        this.type = type;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName() == "getName") {
            if (!Student.class.isAssignableFrom(type)) {
                return "Unknow class";
            } else if (BadStudent.class.isAssignableFrom(type)) {
                return "BadStudetn emtpy";
            } else if (GoodStudent.class.isAssignableFrom(type)) {
                return "GoodStudent empty";
            } else if (NormalStudetn.class.isAssignableFrom(type)) {
                return "NormalStudent empty";
            } else {
                return "Studetn empty";
            }
        }
        return null;
    }

}

public class Main {
    public static void main(String[] args) {
        Room room = new Room("404");
        room.addStudent(new Student("Li Lei"));
        System.out.println(room);
        room.setStudent(1, GoodStudent.NULL);
        room.setStudent(2, BadStudent.NULL);
        room.setStudent(3, NormalStudetn.NULL);
        System.out.println(room);
        room.addStudent(new Student("Han Meimei"));
        System.out.println(room);
    }
}
// 404[Li Lei, Studetn empty, Studetn empty, Studetn empty]
// 404[Li Lei, GoodStudent empty, BadStudetn emtpy, NormalStudent empty]
// 404[Li Lei, Han Meimei, BadStudetn emtpy, NormalStudent empty]