package cn.icexmoon.java.note.ch30.framework;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ch30
 * @Package : cn.icexmoon.java.note.ch30.framework
 * @ClassName : .java
 * @createTime : 2023/3/31 10:52
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@AllArgsConstructor
@Getter
public abstract class AbsHandler {
    protected Method method;
    protected List<Class<?>> paramTypes;
    protected List<String> paramNames;
    protected String uri;

    public static AbsHandler scanMethod(Method method) {
        Parameter[] parameters = method.getParameters();
        List<Class<?>> paramTypes = new ArrayList<>();
        List<String> paramNames = new ArrayList<>();
        for (int i = 0; i < parameters.length; i++) {
            RequestParam rpa = parameters[i].getAnnotation(RequestParam.class);
            if (rpa != null){
                paramNames.add(i, rpa.value());
            }
            else{
                paramNames.add(i, parameters[i].getName());
            }
            paramTypes.add(i, parameters[i].getType());
        }
        GetMapping getMappingAnnotation = method.getAnnotation(GetMapping.class);
        if (getMappingAnnotation != null) {
            String uri = getMappingAnnotation.value();
            return new GetHandler(method, paramTypes, paramNames, uri);
        }
        PostMapping postMappingAnnotation = method.getAnnotation(PostMapping.class);
        if (postMappingAnnotation != null) {
            String uri = postMappingAnnotation.value();
            return new PostHandler(method, paramTypes, paramNames, uri);
        }
        return null;
    }

    protected abstract Object getParam(HttpServletRequest req, String paramName);

    public ModelAndViewer invoke(HttpServletRequest req, HttpServletResponse resp) {
        Object clsInstance = null;
        try {
            clsInstance = method.getDeclaringClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        Object[] args = new Object[paramTypes.size()];
        for (int i = 0; i < paramNames.size(); i++) {
            String pName = paramNames.get(i);
            Class<?> pType = paramTypes.get(i);
            Object arg;
            if (pType == HttpServletRequest.class) {
                arg = req;
            } else if (pType == HttpSession.class) {
                arg = req.getSession();
            } else if (pType == HttpServletResponse.class) {
                arg = resp;
            } else {
                arg = this.getParam(req, pName);
            }
            args[i] = arg;
        }
        try {
            System.out.println(args);
            System.out.println(method.getName());
            return (ModelAndViewer) method.invoke(clsInstance, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
