package ch17.buffer;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        ByteBuffer bb = ByteBuffer.wrap("Hello world!".getBytes("UTF-16BE"));
        CharBuffer cb = bb.asCharBuffer();
        System.out.println(cb);
        exchangeCharBuffer(cb);
        System.out.println(cb);
        exchangeCharBuffer(cb);
        System.out.println(cb);
    }

    private static void exchangeCharBuffer(CharBuffer cb){
        cb.rewind();
        while(cb.hasRemaining()){
            cb.mark();
            char c1 = cb.get();
            char c2 = cb.get();
            cb.reset();
            cb.put(c2);
            cb.put(c1);
        }
        cb.rewind();
    }
}
// Hello world!
// eHll oowlr!d
// Hello world!