package cn.icexmoon.java.note.ch30.framework;

import cn.icexmoon.java.note.ch30.controller.HelloController;
import cn.icexmoon.java.note.ch30.controller.HomeController;
import cn.icexmoon.java.note.ch30.controller.SignController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ch30
 * @Package : cn.icexmoon.java.note.ch30.framework
 * @ClassName : .java
 * @createTime : 2023/3/31 10:07
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@WebServlet(urlPatterns = "/")
public class ServletDispatcher extends HttpServlet {
    private static List<Class<?>> controllerClses = new ArrayList<>();

    static {
        controllerClses.add(HelloController.class);
        controllerClses.add(HomeController.class);
        controllerClses.add(SignController.class);
    }

    private static Map<String, AbsHandler> getMappings = new HashMap<>();
    private static Map<String, AbsHandler> postMappings = new HashMap<>();

    static {
        scan();
    }

    public static final String REDIRECT_FLAG = "redirect:";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandler(req, resp, getMappings);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandler(req, resp, postMappings);
    }

    private void doHandler(HttpServletRequest req, HttpServletResponse resp, Map<String, AbsHandler> mappings) throws ServletException, IOException{
        String path = req.getRequestURI().substring(req.getContextPath().length());
        AbsHandler handler = mappings.get(path);
        if (handler == null) {
            resp.sendError(404);
            return;
        }
        ModelAndViewer mv = handler.invoke(req, resp);
        if (mv == null) {
            return;
        }
        if (mv.getViewer().startsWith(REDIRECT_FLAG)) {
            resp.sendRedirect(mv.getViewer().substring(REDIRECT_FLAG.length()));
            return;
        }
        resp.setContentType("text/html; charset=UTF-8");
        req.setAttribute("data", mv.getModel());
        req.getRequestDispatcher(mv.getViewer()).forward(req, resp);
    }

    private static void scan() {
        for (Class<?> cls : controllerClses) {
            for (Method method : cls.getMethods()) {
                AbsHandler handler = AbsHandler.scanMethod(method);
                if (handler == null) {
                    continue;
                } else if (handler instanceof GetHandler) {
                    getMappings.put(handler.getUri(), handler);
                } else if (handler instanceof PostHandler) {
                    postMappings.put(handler.getUri(), handler);
                } else {
                    continue;
                }
            }
        }
    }
}
