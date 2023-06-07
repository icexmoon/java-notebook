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
 * @createTime : 2023/6/7 9:13
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public record Person(String name, Integer age) {
    private static final int DEFAULT_AGE = 10;
    private static final String DEFAULT_NAME = "icexmoon";

    public Person {
        Objects.requireNonNull(name);
        name = name.trim();
        if ("".equals(name)) {
            throw new RuntimeException("name 不能为空");
        }
        if (age <= 0 || age >= 150) {
            throw new RuntimeException("age 的值非法");
        }
    }

    public Person(String name) {
        this(name, DEFAULT_AGE);
    }

    public static Person defaultPerson() {
        return new Person(DEFAULT_NAME, DEFAULT_AGE);
    }
}
