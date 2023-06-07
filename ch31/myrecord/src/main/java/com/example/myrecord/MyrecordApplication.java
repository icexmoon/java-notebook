package com.example.myrecord;

import com.example.myrecord.entity.Person;
import com.example.myrecord.entity.Person3;
import com.example.myrecord.entity.Person4;
import com.example.myrecord.entity.Person5;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MyrecordApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyrecordApplication.class, args);
        testRecord();
//        Person person = new Person("", 20);
//        Person person1 = new Person("icexmoon", 200);
        testRecord2();
        testRecord3();
        testRecord4();
        testRecord5();
    }

    private static void testRecord5() {
        var p = Person5.builder()
                .firstName("Jack")
                .lastName("Chen")
                .hobbies(List.of("singing", "drawing"))
                .career("actor")
                .address("HK")
                .age(15)
                .email("123@qq.com")
                .build();
        System.out.println(p);
    }

    private static void testRecord4() {
        var p = new Person4("Jack",
                "Chen",
                15,
                List.of("singing", "drawing"),
                "actor",
                "123@qq.com",
                "HK");
        System.out.println(p);
    }

    private static void testRecord3() {
        var p = Person3.buildPerson("icexmoon", 20);
        System.out.println(p);
    }

    private static void testRecord2() {
        Person person2 = new Person("icexmoon", 10);
        System.out.println(person2);
        Person person3 = new Person("icexmoon");
        System.out.println(person3);
    }

    private static void testRecord() {
        Person person = new Person("icexmoon", 12);
        System.out.println(person);
        Person person2 = new Person("icexmoon", 20);
        System.out.println(person.equals(person2));
        Person person3 = new Person("icexmoon", 12);
        System.out.println(person.equals(person3));
    }

}
