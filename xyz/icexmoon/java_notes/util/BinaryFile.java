package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryFile {
    /**
     * 以字节方式读取文件内容并返回
     * 
     * @param fileName 文件名
     * @return 字节数组
     */
    public static byte[] read(String fileName) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
            byte[] b = new byte[bis.available()];
            try {
                bis.read(b);
                return b;
            } finally {
                bis.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void write(String fileName, byte[] b) {
        try {
            BufferedOutputStream br = new BufferedOutputStream(new FileOutputStream(fileName));
            try {
                br.write(b);
            } finally {
                br.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
