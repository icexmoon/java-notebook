package cn.icexmoon.java.note.ch30.controller;

import cn.icexmoon.java.note.ch30.framework.GetMapping;
import cn.icexmoon.java.note.ch30.framework.ModelAndViewer;
import cn.icexmoon.java.note.ch30.framework.PostMapping;
import cn.icexmoon.java.note.ch30.framework.RequestParam;
import jakarta.servlet.http.HttpSession;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ch30
 * @Package : cn.icexmoon.java.note.ch30.controller
 * @ClassName : .java
 * @createTime : 2023/3/31 16:11
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class SignController {
    private static Map<String, String> users = Collections.synchronizedMap(new HashMap<>());

    static {
        users.put("icexmoon", "123");
    }

    @GetMapping("/sign")
    public ModelAndViewer signPage() {
        return new ModelAndViewer("/WEB-INF/sign.jsp", null);
    }

    @PostMapping("/sign")
    public ModelAndViewer sign(HttpSession session,
                               @RequestParam("name") String name,
                               @RequestParam("password") String password) {
        if (!users.containsKey(name)
                || users.get(name) == null
                || !users.get(name).equals(password)){
            //登录失败，跳转到错误信息显示页面
            Map<String, Object> data = new HashMap<>();
            data.put("msg", "用户名或密码错误");
            return new ModelAndViewer("/WEB-INF/error.jsp", data);
        }
        session.setAttribute("user", name);
        return ModelAndViewer.redirect("/hello/home");
    }

    @GetMapping("/exit")
    public ModelAndViewer exit(HttpSession session) {
        session.removeAttribute("user");
        return ModelAndViewer.redirect("/hello/sign");
    }
}
