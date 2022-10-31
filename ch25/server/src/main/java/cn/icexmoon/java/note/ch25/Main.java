package cn.icexmoon.java.note.ch25;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
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
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            try {
                do {
                    String msg = br.readLine();
                    System.out.println(String.format("[%s]received message: %s", addr, msg));
                    if (msg == null || msg.trim().isEmpty()) {
                        continue;
                    }
                    bw.write(new StringBuilder(msg).reverse().toString() + "\n");
                    bw.flush();
                    if (msg.toLowerCase().equals("bye")) {
                        break;
                    }
                }
                while (true);
            } finally {
                System.out.println("stream is closed.");
                br.close();
                bw.close();
            }
        } catch (IOException e) {
            System.out.println(String.format("[%s]connect is closed by IOException.", addr));
            e.printStackTrace();
        } finally {
            clientSocket.close();
            System.out.println(String.format("[]connect is closed normally.", addr));
        }
    }
}
