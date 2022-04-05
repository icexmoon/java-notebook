package ch17.buffer_view;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class Main {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(1024);
        IntBuffer ib = bb.asIntBuffer();
        for (int i = 0; i < 10; i++) {
            ib.put(i);
        }
        ib.flip();
        printIntBuffer(ib);
        ib.put(2, 999);
        ib.rewind();
        printIntBuffer(ib);
    }

    private static void printIntBuffer(IntBuffer ib) {
        while (ib.hasRemaining()) {
            System.out.print(ib.get() + " ");
        }
        System.out.println();
    }
}
// 0 1 2 3 4 5 6 7 8 9 
// 0 1 999 3 4 5 6 7 8 9