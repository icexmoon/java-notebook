package util;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 将字节或字节数组转换为特定类型的工具类
 */
public class BytesConvert {
      /**
     * 从字节数组的指定位置开始读取UTF-8字符串，长度由Java写入时添加的标记确定
     * 
     * @param b        字节数组
     * @param off      起始下标
     * @param encoding 编码
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getUTFStr(byte[] b, int off, String encoding) throws UnsupportedEncodingException {
        int len = getUTFLen(b, off);
        int begin = off + 2;
        byte[] msgBytes = Arrays.copyOfRange(b, begin, begin + len);
        String msg = new String(msgBytes, encoding);
        return msg;
    }

    /**
     * 根据字节数组指定位置，查找下一个UTF字符串长度
     * @param b
     * @param off
     * @return 下一个字符串的字节数
     */
    public static int getUTFLen(byte[] b, int off) {
        // Java使用两个字节标记UTF字符串长度
        String strLen = convertByteToBinaryStr(b[off]) + convertByteToBinaryStr(b[off + 1]);
        return Integer.parseInt(strLen, 2);
    }

    /**
     * 从给定字节数组的特定位置，获取一个整数值并返回
     * @param b
     * @param off
     * @return
     */
    public static int convertBytesToInt(byte[] b, int off) {
        StringBuffer sb = new StringBuffer();
        // 一个int占4字节
        for (int i = off; i < off + Integer.BYTES; i++) {
            sb.append(convertByteToBinaryStr(b[i]));
        }
        int num = Integer.parseInt(sb.toString(), 2);
        return num;
    }

    /**
     * 将给定的字节转换为二进制形式的字符串
     * @param b
     * @return
     */
    public static String convertByteToBinaryStr(byte b) {
        String binaryStr = Integer.toBinaryString(Byte.toUnsignedInt(b));
        binaryStr = String.format("%8s", binaryStr).replace(" ", "0");
        return binaryStr;
    }

    public static String convertBytes2BinaryStr(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(BytesConvert.convertByteToBinaryStr(b));
        }
        return sb.toString();
    }
}
