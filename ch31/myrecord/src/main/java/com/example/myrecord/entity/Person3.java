package com.example.myrecord.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : myrecord
 * @Package : com.example.myrecord.entity
 * @ClassName : .java
 * @createTime : 2023/6/7 11:12
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Value
@Getter(AccessLevel.PRIVATE)
public class Person3 {
    String name;
    Integer age;

    private Person3(final String name, final Integer age) {
        this.name = name;
        this.age = age;
    }

    public static Person3 buildPerson(String name, Integer age) {
        return new Person3(name, age);
    }
}
