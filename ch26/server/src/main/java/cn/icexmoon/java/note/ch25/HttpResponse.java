package cn.icexmoon.java.note.ch25;

import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : server
 * @Package : cn.icexmoon.java.note.ch25
 * @ClassName : .java
 * @createTime : 2022/11/1 10:10
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Accessors(chain = true)
@Setter
public class HttpResponse {
    private String schema;
    private Integer code;
    private String desc;
    private Map<String, List<String>> headers = new LinkedHashMap<>();
    private String body;

    public HttpResponse setCode(Integer code) {
        this.code = code;
        if (code.equals(200)) {
            desc = "ok";
        }
        return this;
    }

    /**
     * 添加响应报文头，同一个报文头可以调用多次添加多个值
     * @param key
     * @param value
     */
    public void addHeader(String key, String value){
        if (!headers.containsKey(key)){
            headers.put(key, new LinkedList<>());
        }
        List<String> values = headers.get(key);
        values.add(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(schema).append(" ").append(code).append(" ").append(desc).append("\n");
        if (headers != null) {
            headers.forEach((key, values) -> {
                sb.append(key).append(":");
                values.forEach(v -> {
                    sb.append(v).append(",");
                });
                if (sb.charAt(sb.length() - 1) == ',') {
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append("\n");
            });
        }
        sb.append("\n");
        if (body != null && !body.isEmpty()) {
            sb.append(body);
        }
        return sb.toString();
    }

    public static HttpResponse buildSuccessResponse() {
        return new HttpResponse()
                .setCode(200)
                .setDesc("ok")
                .setSchema("HTTP/1.1")
                .setBody("");
    }
}
