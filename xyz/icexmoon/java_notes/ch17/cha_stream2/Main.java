package ch17.cha_stream2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import util.BytesConvert;

public class Main {
    public static void main(String[] args) throws IOException {
        final String CURRENT_DIR = "./xyz/icexmoon/java_notes/ch17/cha_stream2/";
        final String FILE_NAME = "data.out";
        DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(new File(CURRENT_DIR + FILE_NAME))));
        dos.writeInt(999);
        dos.writeUTF("你好！我来了。");
        dos.writeUTF("再见！我走了。");
        dos.writeInt(666);
        dos.close();
        final String FILE_ENCODING = System.getProperty("file.encoding");
        System.out.println(FILE_ENCODING);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(CURRENT_DIR + FILE_NAME));
        byte[] b = new byte[bis.available()];
        bis.read(b);
        bis.close();
        int index = 0;
        int num = BytesConvert.convertBytesToInt(b, index);
        System.out.println(num);
        index += Integer.BYTES;
        String msg = BytesConvert.getUTFStr(b, index, FILE_ENCODING);
        System.out.println(msg);
        index += BytesConvert.getUTFLen(b, index) + 2;
        msg = BytesConvert.getUTFStr(b, index, FILE_ENCODING);
        System.out.println(msg);
        index += BytesConvert.getUTFLen(b, index) + 2;
        num = BytesConvert.convertBytesToInt(b, index);
        System.out.println(num);
        index += Integer.BYTES;
    }
}
// 999
// 你好！我来了。
// 再见！我走了。
// 666