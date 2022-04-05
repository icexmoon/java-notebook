package ch17.basic_type;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

import util.Fmt;

public class Main {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[] { 0, 0, 0, 0, 0, 0, 0, 'a' });
        int index = 0;
        while (bb.hasRemaining()) {
            Fmt.printf("%d=>%s ", index++, bb.get());
        }
        System.out.println();
        bb.rewind();
        CharBuffer cb = bb.asCharBuffer();
        index = 0;
        while (cb.hasRemaining()) {
            char c = cb.get();
            Fmt.printf("%d=>%s ", index++, c);
        }
        System.out.println();
        index = 0;
        ShortBuffer sb = bb.asShortBuffer();
        while (sb.hasRemaining()) {
            Fmt.printf("%d=>%s ", index++, sb.get());
        }
        System.out.println();
        index = 0;
        IntBuffer ib = bb.asIntBuffer();
        while (ib.hasRemaining()) {
            Fmt.printf("%d=>%s ", index++, ib.get());
        }
        System.out.println();
        index = 0;
        FloatBuffer fb = bb.asFloatBuffer();
        while(fb.hasRemaining()){
            Fmt.printf("%d=>%s ", index++, fb.get());
        }
        System.out.println();
        index = 0;
        LongBuffer lb = bb.asLongBuffer();
        while(lb.hasRemaining()){
            Fmt.printf("%d=>%s ", index++, lb.get());
        }
        System.out.println();
        index = 0;
        DoubleBuffer db = bb.asDoubleBuffer();
        while(db.hasRemaining()){
            Fmt.printf("%d=>%s ", index++, db.get());
        }
        System.out.println();
    }
}
// 0=>0 1=>0 2=>0 3=>0 4=>0 5=>0 6=>0 7=>97 
// 0=> 1=> 2=> 3=>a
// 0=>0 1=>0 2=>0 3=>97 
// 0=>0 1=>97
// 0=>0.0 1=>1.36E-43
// 0=>97 
// 0=>4.8E-322