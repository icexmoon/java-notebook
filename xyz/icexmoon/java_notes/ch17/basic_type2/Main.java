package ch17.basic_type2;

import java.nio.ByteBuffer;

public class Main {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(1024);
        bb.asCharBuffer().put("Hello world!");
        do {
            char c = bb.getChar();
            if (c == 0) {
                break;
            }
            System.out.print(c);
        } while (true);
        System.out.println();
        bb.rewind();
        bb.asShortBuffer().put((short) 9999999);
        System.out.println(bb.getShort());
        bb.rewind();
        bb.asIntBuffer().put(9999999);
        System.out.println(bb.getInt());
        bb.rewind();
        bb.asLongBuffer().put(9999999);
        System.out.println(bb.getLong());
        bb.rewind();
        bb.asFloatBuffer().put(9999999);
        System.out.println(bb.getFloat());
        bb.rewind();
        bb.asDoubleBuffer().put(9999999);
        System.out.println(bb.getDouble());
    }
}
// Hello world!
// -27009
// 9999999
// 9999999
// 9999999.0
// 9999999.0