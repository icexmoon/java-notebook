package cn.icexmoon.java.note.ch30.framework;

import jakarta.servlet.http.HttpServletRequest;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ch30
 * @Package : cn.icexmoon.java.note.ch30.framework
 * @ClassName : .java
 * @createTime : 2023/3/31 10:59
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class PostHandler extends AbsHandler{
    public PostHandler(Method method, List<Class<?>> paramTypes, List<String> paramNames, String uri) {
        super(method, paramTypes, paramNames, uri);
    }

    @Override
    protected Object getParam(HttpServletRequest req, String paramName) {
        return req.getParameter(paramName);
    }
}
