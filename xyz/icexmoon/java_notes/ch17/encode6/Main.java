package ch17.encode6;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "Hello world!";
        printBytes(msg.getBytes());
        printBytes(msg.getBytes("ASCII"));
        printBytes(msg.getBytes("UTF-16BE"));
        printBytes(msg.getBytes("UTF-8"));
        ByteBuffer bb = ByteBuffer.allocate(255);
        bb.asCharBuffer().put(msg);
        bb.limit(msg.getBytes("UTF-16BE").length);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(bb.hasRemaining()){
            sb.append(bb.get());
            sb.append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append("]");
        System.out.println(sb.toString());
    }

    private static void printBytes(byte[] b) {
        System.out.println(Arrays.toString(b));
    }
}
// [72, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100, 33]
// [72, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100, 33]
// [0, 72, 0, 101, 0, 108, 0, 108, 0, 111, 0, 32, 0, 119, 0, 111, 0, 114, 0, 108, 0, 100, 0, 33]
// [72, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100, 33]
// [0, 72, 0, 101, 0, 108, 0, 108, 0, 111, 0, 32, 0, 119, 0, 111, 0, 114, 0, 108, 0, 100, 0, 33]