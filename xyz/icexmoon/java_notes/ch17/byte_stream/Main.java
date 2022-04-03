package ch17.byte_stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final String currentDir = "./xyz/icexmoon/java_notes/ch17/byte_stream/";
        DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(new File(currentDir + "data.out"))));
        dos.writeInt(999);
        dos.writeUTF("你好！");
        dos.close();
        DataInputStream dis = new DataInputStream(
                new BufferedInputStream(new FileInputStream(currentDir + "data.out")));
        int num = dis.readInt();
        String msg = dis.readUTF();
        System.out.println(num);
        System.out.println(msg);
        dis.close();
    }
}
// 999
// 你好！
