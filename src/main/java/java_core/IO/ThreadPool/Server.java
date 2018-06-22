package java_core.IO.ThreadPool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) throws IOException {
        final ServerSocket socket = new ServerSocket(9090);
        Executor executor = Executors.newFixedThreadPool(10);
        while (true) {
            final Socket clientSocket = socket.accept();
            executor.execute(new java_core.IO.ThreadPool.RequestHandler(clientSocket));
            clientSocket.close();
        }
    }
}
