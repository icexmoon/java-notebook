package ch20.extract_interface;

@ExtractInterface("Actionable")
public class Student {
    public void action() {
        System.out.println("student start doing something.");
    }
}
