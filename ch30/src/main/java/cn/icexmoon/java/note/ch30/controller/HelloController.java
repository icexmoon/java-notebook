package cn.icexmoon.java.note.ch30.controller;

import cn.icexmoon.java.note.ch30.framework.GetMapping;
import cn.icexmoon.java.note.ch30.framework.ModelAndViewer;
import cn.icexmoon.java.note.ch30.framework.RequestParam;

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
 * @createTime : 2023/3/31 10:17
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class HelloController {
    @GetMapping("/")
    public ModelAndViewer helloPage(@RequestParam("name") String name){
        Map<String, Object> data = new HashMap<>();
        data.put("name", name);
        return new ModelAndViewer("/WEB-INF/hello.jsp", data);
    }
}
