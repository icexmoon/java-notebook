package ch11.scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        BufferedReader br = new BufferedReader(new FileReader(fname));
        List<Person> list = new ArrayList<>();
        try {
            String line;
            while ((line = br.readLine()) != null) {
                String[] info = line.split(",");
                int age = Integer.parseInt(info[1]);
                Sex sex = Sex.MALE;
                if (info[2].equals("female")) {
                    sex = Sex.FEMALE;
                }
                list.add(new Person(info[0], age, sex));
            }

        } finally {
            br.close();
        }
        System.out.println(list);
    }
}
// [Person [age=20, name=Han mei, sex=FEMALE], Person [age=15, name=Li Lei, sex=MALE]]
