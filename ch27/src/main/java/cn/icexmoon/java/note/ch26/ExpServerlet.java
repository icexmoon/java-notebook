package cn.icexmoon.java.note.ch26;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : my_serverlet
 * @Package : PACKAGE_NAME
 * @ClassName : .java
 * @createTime : 2023/3/28 12:34
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@WebServlet(urlPatterns = "/")
public class ExpServerlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (name == null) {
            name = "none";
        }
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.print("<h1>This is a first serverlet app example.</h1>");
        String msg = String.format("<div>hello %s</div>", name);
        writer.print(msg);
        writer.flush();
    }
}
