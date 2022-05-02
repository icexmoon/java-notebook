package ch22.io_block;

import java.io.IOException;
import java.io.InputStream;

class IOInterrupt implements Runnable {
    private InputStream input;

    public IOInterrupt(InputStream input) {
        this.input = input;
    }

    @Override
    public void run() {
        System.out.println("wait for io read and block...");
        try {
            input.read();
        } catch (Exception e) {
            if (Thread.interrupted()) {
                System.out.println("interrupt is happen.");
            }
            System.out.println(e);
        }
        System.out.println("IOInterrupt.run is exit.");
    }

}