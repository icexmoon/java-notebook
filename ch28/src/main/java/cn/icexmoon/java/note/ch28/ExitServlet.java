package cn.icexmoon.java.note.ch28;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ch28
 * @Package : cn.icexmoon.java.note.ch28
 * @ClassName : .java
 * @createTime : 2023/3/29 15:36
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@WebServlet(urlPatterns = "/exit")
public class ExitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //删除session
        req.getSession().removeAttribute("user");
        //跳转到登录页
        resp.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        resp.setHeader("Location", "/hello/sign");
    }
}
