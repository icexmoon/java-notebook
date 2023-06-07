package com.example.myrecord.system;


import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : myrecord
 * @Package : com.example.myrecord.system
 * @ClassName : .java
 * @createTime : 2023/6/7 10:16
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public record Result<T>(boolean successFlag, String errorCode, String errorMsg, T data) {
    private static final String SUCCESS_CODE = "success";

    public Result {
        Objects.requireNonNull(errorCode);
        Objects.requireNonNull(errorMsg);
        errorCode = errorCode.trim();
        if ("".equals(errorCode)) {
            throw new RuntimeException("errorCode 不能为空");
        }
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(true, SUCCESS_CODE, "", data);
    }

    public static Result<Object> success() {
        return success(null);
    }

    public static Result<Object> fail(String errorCode, String errorMsg) {
        return new Result<>(false, errorCode, errorMsg, null);
    }
}
