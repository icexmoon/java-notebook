package ch11.scanner3;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.MatchResult;

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
        scanner.useDelimiter("\r\n");
        List<Person> persons = new ArrayList<>();
        String pattern = "(\\w+(\\s+\\w+)?),(\\d+),(\\w+)";
        while (scanner.hasNext(pattern)) {
            scanner.next(pattern);
            MatchResult mr = scanner.match();
            String name = mr.group(1);
            String ageStr = mr.group(3);
            String sexStr = mr.group(4);
            int age = Integer.parseInt(ageStr);
            Sex sex = Sex.FEMALE;
            if (sexStr.equals("male")) {
                sex = Sex.MALE;
            }
            persons.add(new Person(name, age, sex));
        }
        System.out.println(persons);
    }
}
// [Person [age=20, name=Han mei, sex=FEMALE], Person [age=15, name=Li Lei,
// sex=MALE]]
