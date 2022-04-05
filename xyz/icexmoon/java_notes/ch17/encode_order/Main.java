package ch17.encode_order;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import util.BytesConvert;

public class Main {
    public static void main(String[] args) {
        byte[] bytes = new byte[2];
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        bb.asCharBuffer().put('H');
        System.out.println(convertBytes2BinaryStr(bytes));
        bb.rewind();
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.asCharBuffer().put('H');
        System.out.println(convertBytes2BinaryStr(bytes));
        bb.rewind();
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.asCharBuffer().put('H');
        System.out.println(convertBytes2BinaryStr(bytes));
    }

    public static String convertBytes2BinaryStr(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(BytesConvert.convertByteToBinaryStr(b));
        }
        return sb.toString();
    }
}
// 0000000001001000
// 0100100000000000
// 0000000001001000