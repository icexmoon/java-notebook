package cn.icexmoon.java.note.ch25;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : server
 * @Package : cn.icexmoon.java.note.ch25
 * @ClassName : .java
 * @createTime : 2022/11/1 9:23
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Getter
public class HttpRequest {
    private String headLine;
    private Map<String, List<String>> headers = new LinkedHashMap<>();
    private String body;
    private String httpMethod;
    private String url;
    private String schema;

    public HttpRequest(BufferedReader br) throws IOException {
        //处理首行
        headLine = br.readLine();
        String[] hlPart = headLine.split(" ");
        if (hlPart.length < 3) {
            throw new RuntimeException("请求报文首行格式错误");
        }
        httpMethod = hlPart[0];
        url = hlPart[1];
        schema = hlPart[2];
        //处理报文头
        boolean requestReadEnd = false;
        do {
            String header = br.readLine();
            if (header == null) {
                //报文读取结束
                requestReadEnd = true;
                break;
            }
            if (header.isEmpty()) {
                //报文头结束
                break;
            }
            int separatorIdx = header.indexOf(":");
            if (separatorIdx <= 0) {
                throw new RuntimeException("报文头格式错误，缺少分隔符");
            }
            String headerKey = header.substring(0, separatorIdx);
            String headerValues;
            try {
                headerValues = header.substring(separatorIdx + 1);
                headerValues = headerValues.trim();
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
                throw new RuntimeException("报文头格式错误，缺少值");
            }
            if (headerValues == null || headerValues.isEmpty()) {
                this.headers.put(headerKey, null);
            }
            else{
                String[] values = headerValues.split(",");
                List<String> valuesList = Arrays.stream(values).map(v -> v.trim()).collect(Collectors.toList());
                this.headers.put(headerKey, valuesList);
            }
        }
        while (true);
        if (requestReadEnd) {
            this.body = "";
            return;
        }
        //处理报文体
        String contentLength = getFirstHeaderVal("Content-Length");
        if (contentLength != null) {
            if (Integer.valueOf(contentLength).compareTo(0) <= 0) {
                this.body = "";
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        final int SIZE = Integer.valueOf(contentLength);
        char[] bodyBf = new char[SIZE];
        br.read(bodyBf);
        this.body = new String(bodyBf);
    }

    /**
     * 获取第一个报文头的值
     *
     * @param headerKey 报文头的key
     * @return 如果缺少报文头或者报文头没有值，返回null
     */
    private String getFirstHeaderVal(String headerKey) {
        if (!headers.containsKey(headerKey)) {
            return null;
        }
        if (headers.get(headerKey) == null) {
            return null;
        }
        return headers.get(headerKey).get(0);
    }
}
