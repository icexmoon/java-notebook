package com.example.myrecord.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : myrecord
 * @Package : com.example.myrecord.entity
 * @ClassName : .java
 * @createTime : 2023/6/7 11:31
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Setter(value = AccessLevel.NONE)
@RequiredArgsConstructor
public class Person5 {
    String firstName;
    String lastName;
    Integer age;
    List<String> hobbies;
    String career;
    String email;
    String address;
}
