package cn.icexmoon.java.note.ch30.controller;

import cn.icexmoon.java.note.ch30.framework.GetMapping;
import cn.icexmoon.java.note.ch30.framework.ModelAndViewer;
import cn.icexmoon.java.note.ch30.framework.ServletDispatcher;
import jakarta.servlet.http.HttpSession;

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
 * @createTime : 2023/3/31 10:13
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class HomeController {
    @GetMapping("/home")
    public ModelAndViewer homePage(HttpSession session) {
        String user = (String) session.getAttribute("user");
        if (user == null || user.isEmpty()) {
            //没有登录，跳转到登录页
            return new ModelAndViewer(ServletDispatcher.REDIRECT_FLAG + "/hello/sign", null);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("name", user);
        return new ModelAndViewer("/WEB-INF/home.jsp", data);
    }
}
