package cn.icexmoon.java.note.ch30.framework;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ch30
 * @Package : cn.icexmoon.java.note.ch30.framework
 * @ClassName : .java
 * @createTime : 2023/3/31 10:14
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data
@AllArgsConstructor
public class ModelAndViewer {
    private String viewer;
    private Map<String, ?> model;

    public static ModelAndViewer redirect(String targetUri) {
        return new ModelAndViewer(ServletDispatcher.REDIRECT_FLAG + targetUri, null);
    }
}
