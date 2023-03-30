package cn.icexmoon.java.note.ch28;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ch28
 * @Package : cn.icexmoon.java.note.ch28
 * @ClassName : .java
 * @createTime : 2023/3/29 14:38
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@WebServlet(urlPatterns = "/sign")
public class SignServlet extends HttpServlet {
    private static Map<String, String> users = Collections.synchronizedMap(new HashMap<>());

    static {
        users.put("icexmoon", "123");
    }

    /**
     * 返回登录页面
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = (String) req.getSession().getAttribute("user");
        if (user != null){
            resp.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            resp.setHeader("Location", "/hello/home");
            return;
        }
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String pageContent = this.getSignPage();
        writer.print(pageContent);
        writer.flush();
    }

    /**
     * 执行登录动作
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if (!checkLogin(name, password)){
            resp.setContentType("text/html; charset=UTF-8");
            //登录失败
            PrintWriter writer = resp.getWriter();
            writer.print("<h1>用户名或密码错误</h1>");
            writer.flush();
        }
        else {
            //登录成功
            //写入session
            req.getSession().setAttribute("user", name);
            //跳转到home页
            resp.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            resp.setHeader("Location", "/hello/home");
        }
    }

    /**
     * 检查用户密码是否正确
     * @param name
     * @param password
     * @return
     */
    private static boolean checkLogin(String name, String password){
        if (name == null || name.isEmpty()){
            return false;
        }
        if (password == null || password.isEmpty()){
            return false;
        }
        if (!users.containsKey(name)){
            return false;
        }
        String correctPass = users.get(name);
        if (correctPass == null){
            return false;
        }
        if (!correctPass.equals(password)){
            return false;
        }
        return true;
    }

    private static String getSignPage() {
        StringBuilder sb = new StringBuilder();
        sb.append("<form action=\"/hello/sign\" method=\"post\">");
        sb.append("用户名<input name=\"name\"/><br/>");
        sb.append("密码<input name=\"password\"/><br/>");
        sb.append("<button type=\"submit\">登录</button>");
        sb.append("</form>");
        return sb.toString();
    }
}
