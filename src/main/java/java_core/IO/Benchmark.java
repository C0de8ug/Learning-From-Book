package java_core.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by Administrator on 2017/3/5 0005.
 */
public class Benchmark {
    public static long num = 0;

    public static void main(String[] args) throws IOException {
        while (true) {
            num++;
            System.out.println(String.valueOf(num));
            Thread thread = new Thread(() -> {
                try {
                    Socket socket = new Socket("127.0.0.1", 9999);

                    socket.getOutputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }
}
