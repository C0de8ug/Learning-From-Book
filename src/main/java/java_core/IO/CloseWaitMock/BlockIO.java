package java_core.IO.CloseWaitMock;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2017/3/5 0005.
 */
public class BlockIO {

    public static void main(String[] args) throws IOException {
        final ServerSocket socket = new ServerSocket(9090);
        while (true) {
            final Socket clientSocket = socket.accept();
        }
    }
}
