package com.example.myrecord.controller;

import com.example.myrecord.system.Result;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.extern.log4j.Log4j2;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : myrecord
 * @Package : com.example.myrecord
 * @ClassName : .java
 * @createTime : 2023/6/7 10:15
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/person")
@Log4j2
public class PersonController {
    private static record AddPersonDTO(@NotBlank String name,
                                       @NotNull @Range(min = 1, max = 150) Integer age){
    }

    @PostMapping("/add")
    public Result<?> addPerson(@Validated @RequestBody AddPersonDTO dto){
        //调用service，执行添加动作
        log.debug(dto);
        return Result.success();
    }
}
