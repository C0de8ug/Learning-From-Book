package java_core.IO.ThreadPool;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Administrator on 2017/3/26 0026.
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.123", 8989);

        OutputStream out = socket.getOutputStream();
        String temp = "hello world";
        out.write(temp.getBytes());
        out.flush();
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[65536];
        while (inputStream.read(buffer) != -1) {
            System.out.println("echo: " + new String(buffer));
        }
        socket.close();
    }
}
