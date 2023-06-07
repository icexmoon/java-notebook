package com.example.myrecord.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : myrecord
 * @Package : com.example.myrecord.entity
 * @ClassName : .java
 * @createTime : 2023/6/7 11:41
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Value
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Person6 extends Person5 {
    private final String country;
    public Person6(String firstName, String lastName, Integer age, List<String> hobbies, String career, String email, String address, String country) {
        super(firstName, lastName, age, hobbies, career, email, address);
        this.country = country;
    }
}
