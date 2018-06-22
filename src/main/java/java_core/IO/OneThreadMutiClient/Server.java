package java_core.IO.OneThreadMutiClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        final ServerSocket socket = new ServerSocket(9090);
        while (true) {
            final Socket clientSocket = socket.accept();
            InputStream inputStream = clientSocket.getInputStream();
            while (inputStream.read() != -1) {
            }
            clientSocket.close();
        }
    }
}
