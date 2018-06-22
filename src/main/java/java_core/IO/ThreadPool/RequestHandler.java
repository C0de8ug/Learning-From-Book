package java_core.IO.ThreadPool;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class RequestHandler implements Runnable {
    Socket socket;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    public void process() throws IOException {
        InputStream inputStream = socket.getInputStream();
        byte[] data = new byte[65535];
        while (inputStream.read(data) != -1) {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(data);
        }
    }

    @Override
    public void run() {

    }
}
