package java_core.IO.CloseWaitMock;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Administrator on 2017/3/26 0026.
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.207.129", 9090);
        socket.close();
    }
}
