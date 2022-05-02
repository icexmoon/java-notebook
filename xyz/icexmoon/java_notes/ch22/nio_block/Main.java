package ch22.nio_block;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class NioBlock implements Runnable {
    private SocketChannel sc;

    public NioBlock(SocketChannel sc) {
        this.sc = sc;
    }

    @Override
    public void run() {
        try {
            System.out.println("use nio wait socket and block...");
            sc.read(ByteBuffer.allocate(1));
        } catch (IOException e) {
            if (Thread.interrupted()) {
                System.out.println("interrupt is happen.");
            }
            System.out.println(e);
        }
        System.out.println(this.getClass().getSimpleName()+".run() is exit.");
    }

}

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket ss = new ServerSocket(8080);
        InetSocketAddress isa = new InetSocketAddress("localhost", 8080);
        SocketChannel sc1 = SocketChannel.open(isa);
        SocketChannel sc2 = SocketChannel.open(isa);
        ExecutorService es = Executors.newCachedThreadPool();
        Future<?> result = es.submit(new NioBlock(sc1));
        es.execute(new NioBlock(sc2));
        TimeUnit.SECONDS.sleep(1);
        es.shutdown();
        result.cancel(true);
        TimeUnit.SECONDS.sleep(1);
        sc2.close();
        ss.close();
    }
}
// use nio wait socket and block...
// use nio wait socket and block...
// interrupt is happen.
// java.nio.channels.ClosedByInterruptException
// NioBlock.run() is exit.
// java.nio.channels.AsynchronousCloseException
// NioBlock.run() is exit.