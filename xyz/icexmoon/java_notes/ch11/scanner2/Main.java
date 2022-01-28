package ch11.scanner2;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

enum Sex {
    MALE, FEMALE
}

class Person {
    String name = "";
    int age;
    Sex sex = Sex.FEMALE;

    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + ", sex=" + sex + "]";
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        String fname = "D:\\workspace\\java\\java-notebook\\xyz\\icexmoon\\java_notes\\ch11\\scanner\\persons.txt";
        Scanner scanner = new Scanner(new FileReader(fname));
        scanner.useDelimiter(",|\n");
        List<Person> persons = new ArrayList<>();
        while (true) {
            try {
                String name = scanner.next();
                int age = scanner.nextInt();
                String sexStr = scanner.next();
                Sex sex = Sex.MALE;
                if (sexStr.equals("female")) {
                    sex = Sex.FEMALE;
                }
                persons.add(new Person(name, age, sex));
            } catch (NoSuchElementException e) {
                break;
            }
        }
        System.out.println(persons);
    }
}
// [Person [age=20, name=Han mei, sex=FEMALE], Person [age=15, name=Li Lei,
// sex=MALE]]
