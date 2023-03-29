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
 * @createTime : 2023/3/29 11:07
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@WebServlet(urlPatterns = "/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        //302 临时重定向
//        resp.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        //301 永久重定向
        resp.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        String url = "/hello/";
        if (name != null) {
            url += String.format("?name=%s", name);
        }
        resp.setHeader("Location", url);
    }
}
