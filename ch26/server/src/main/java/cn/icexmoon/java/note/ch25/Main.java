package cn.icexmoon.java.note.ch25;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : server
 * @Package : cn.icexmoon.java.note.ch25
 * @ClassName : .java
 * @createTime : 2022/10/31 14:25
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666);
        System.out.println("server is starting...");
        ExecutorService es = Executors.newCachedThreadPool();
        while (true) {
            Socket client = ss.accept();
            final Socket finalClient = client;
            es.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        System.out.println("get connection from " + finalClient.getRemoteSocketAddress());
                        dealRequest(finalClient);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private static void dealRequest(Socket clientSocket) throws IOException {
        String addr = clientSocket.getRemoteSocketAddress().toString();
        try {
            InputStream is = clientSocket.getInputStream();
            OutputStream os = clientSocket.getOutputStream();
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
            HttpRequest httpRequest = new HttpRequest(br);
            System.out.println("=============http request=========");
            System.out.println("http method:" + httpRequest.getHttpMethod());
            System.out.println("url:" + httpRequest.getUrl());
            System.out.println("schema:" + httpRequest.getSchema());
            System.out.println("============header==========");
            httpRequest.getHeaders().forEach((key, values) -> {
                System.out.println(key + ":" + values);
            });
            System.out.println("==========body============");
            System.out.println(httpRequest.getBody());
            //返回响应报文
            String bodyStr = "{\"code\":401,\"data\":null,\"msg\":\"你好\"}";
            int length = bodyStr.getBytes(StandardCharsets.UTF_8).length;
            HttpResponse httpResponse = HttpResponse.buildSuccessResponse();
            httpResponse.addHeader("Content-Type", "application/json;charset=utf-8");
            httpResponse.addHeader("Content-Length", Integer.valueOf(length).toString());
            httpResponse.addHeader("Keep-Alive", "timeout=60");
            httpResponse.setBody(bodyStr);
            bw.write(httpResponse.toString());
            bw.flush();
            System.out.println("========response=============");
            System.out.println(httpResponse.toString());
        } catch (Exception e) {
            System.out.println(String.format("[%s]connect is closed by IOException.", addr));
            e.printStackTrace();
        } finally {
            clientSocket.close();
            System.out.println(String.format("[]connect is closed normally.", addr));
        }
    }

    private static void printWholeRequest(BufferedReader br) throws IOException {
        do {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
        while (true);
    }
}
