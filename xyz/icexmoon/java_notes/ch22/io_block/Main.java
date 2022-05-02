package ch22.io_block;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        ServerSocket ss = new ServerSocket(8081);
        InputStream in = new Socket("localhost", 8081).getInputStream();
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new IOInterrupt(System.in));
        es.execute(new IOInterrupt(in));
        TimeUnit.SECONDS.sleep(1);
        es.shutdown();
        System.out.println("close socket.");
        in.close();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("close system.in");
        System.in.close();
    }
}
// wait for io read and block...
// wait for io read and block...
// close socket.
// java.net.SocketException: Socket closed
// IOInterrupt.run is exit.
// close system.in