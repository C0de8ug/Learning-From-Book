package java_core.IO.ThreadPerClient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        final ServerSocket socket = new ServerSocket(9090);
        while (true) {
            final Socket clientSocket = socket.accept();
            Thread thread = new Thread(new RequestHandler(clientSocket));
            thread.start();
            clientSocket.close();
        }
    }
}
