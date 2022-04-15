package ch20.usecase;

import java.util.ArrayList;
import java.util.List;

import util.Fmt;

public class ClassRoom {
    private static final int LIMIT = 30;
    private static int counter = 0;
    private final int ID = ++counter;
    private int grade = 1;
    private int theClass = 1;

    private List<Student> students = new ArrayList<>();

    public ClassRoom(int grade, int theClass) {
        this.grade = grade;
        this.theClass = theClass;
    }

    @UseCase(id = 1, description = "add student use case.")
    public boolean addStudent(Student s) {
        if (students.size() >= LIMIT) {
            return false;
        }
        students.add(s);
        return true;
    }

    @UseCase(id = 2, description = "remove student from classroom use case.")
    public boolean removeStudent(Student s) {
        return students.remove(s);
    }

    @Override
    public String toString() {
        return Fmt.sprintf("ClassRoom(ID%d,%dGrade%dClass,total%d)", ID, grade, theClass, students.size());
    }
}
