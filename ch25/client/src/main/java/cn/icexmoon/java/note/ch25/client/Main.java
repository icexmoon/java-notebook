package cn.icexmoon.java.note.ch25.client;

import java.io.*;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : client
 * @Package : cn.icexmoon.java.note.ch25.client
 * @ClassName : .java
 * @createTime : 2022/10/31 14:47
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6666);
        sendMsg(socket);
    }

    private static void sendMsg(Socket socket) throws IOException {
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            BufferedReader stdReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("server is connected.");
            try {
                do {
                    System.out.println("please enter some messages:");
                    String msg = stdReader.readLine();
                    bw.write(msg + "\n");
                    bw.flush();
                    System.out.println(String.format("msg is send to server."));
                    System.out.println("ready to get msg back from server...");
                    String msgBack = br.readLine();
                    System.out.println("get back msg: " + msgBack);
                    if (msgBack.toLowerCase().equals("eyb")) {
                        break;
                    }
                }
                while (true);
            } finally {
                br.close();
                bw.close();
                System.out.println("stream is closed.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            socket.close();
            System.out.println("connect is closed caused IOException.");
        } finally {
            socket.close();
        }

    }
}
