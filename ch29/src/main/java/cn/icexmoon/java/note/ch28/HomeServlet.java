package cn.icexmoon.java.note.ch28;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ch28
 * @Package : cn.icexmoon.java.note.ch28
 * @ClassName : .java
 * @createTime : 2023/3/29 15:17
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = (String) req.getSession().getAttribute("user");
        if (name == null) {
            //没有登录
            resp.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            resp.setHeader("Location", "/hello/sign");
            return;
        }
        //如果客户端没有记录天气，就写入cookie
        String clientWeather = getWeatherFromCookie(req);
        String nowWeather;
        if (clientWeather == null) {
            String weather = getWeather();
            writeWeather2Cookie(resp, weather);
            nowWeather = weather;
        } else {
            nowWeather = clientWeather;
        }
        //已经登录
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        //显示天气
        writer.print(String.format("<div>%s</div>", nowWeather));
        writer.print("<h1>This is your home page</h1>");
        writer.print(String.format("<div>hello, %s</div>", name));
        writer.print("<div><a href=\"/hello/exit\">注销</a></div>");
        writer.flush();
    }

    private static String getWeather() {
        String[] weathers = {"天气晴 15度~20度", "天气阴 10度~20度", "多云转阴 15度~22度"};
        Random random = new Random();
        int i = random.nextInt(weathers.length);
        return weathers[i];
    }

    private String getWeatherFromCookie(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            return null;
        }
        for (Cookie c : cookies) {
            if (c.getName().equals("weather")) {
                String weather = c.getValue();
                weather = new String(Base64.getDecoder().decode(weather), Charset.forName("UTF-8"));
                return weather;
            }
        }
        return null;
    }

    private void writeWeather2Cookie(HttpServletResponse resp, String weather) {
        String encodedWeather = Base64.getEncoder().encodeToString(weather.getBytes(StandardCharsets.UTF_8));
        Cookie cookie = new Cookie("weather", encodedWeather);
        //有效期为1天
        cookie.setMaxAge(24 * 60 * 60);
        resp.addCookie(cookie);
    }
}
