package com.example.myrecord.entity;

import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : myrecord
 * @Package : com.example.myrecord.entity
 * @ClassName : .java
 * @createTime : 2023/6/7 9:22
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class Person1 {
    private final String name;
    private final Integer age;

    public Person1(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person1 person1 = (Person1) o;
        return Objects.equals(getName(), person1.getName()) && Objects.equals(getAge(), person1.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
