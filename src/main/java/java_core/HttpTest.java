package java_core;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * Created with .
 * Date: 14-5-27
 * Time: 上午11:38
 * To change this template use File | Settings | File Templates.
 */
public class HttpTest {


    private static byte[] request = null;

    static {
        StringBuffer temp = new StringBuffer();
        temp.append("GET http://www.tuicool.com/articles/An6RVrN HTTP/1.1\r\n");
        temp.append("Host: 127.0.0.1:8080\r\n");
        temp.append("Connection: keep-alive\r\n");
        temp.append("Cache-Control: max-age=0\r\n");
        temp
                .append("User-Agent: Mozilla/5.0 (Windows NT 5.1) AppleWebKit/536.11 (KHTML, like Gecko) Chrome/20.0.1132.47 Safari/536.11\r\n");
        temp
                .append("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n");
        temp.append("Accept-Encoding: gzip,deflate,sdch\r\n");
        temp.append("Accept-Language: zh-CN,zh;q=0.8\r\n");
        temp.append("Accept-Charset: GBK,utf-8;q=0.7,*;q=0.3\r\n");
        temp.append("\r\n");
        request = temp.toString().getBytes();
    }

    public static void sendHttpRequest() throws Exception {
        try {

            final SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 9999));
            final Charset charset = Charset.forName("GBK");// 创建GBK字符集  
            socketChannel.configureBlocking(false);//配置通道使用非阻塞模式  

            while (!socketChannel.finishConnect()) {
                Thread.sleep(10);
            }
            //proxySocketChannel.write(charset.encode("GET " + "http://localhost:8080/feifei/helloStruts-sayHello.action HTTP/1.1" + "\r\n\r\n"));  
            socketChannel.write(ByteBuffer.wrap(request));

            int read = 0;
            boolean readed = false;
            ByteBuffer buffer = ByteBuffer.allocate(1024);// 创建1024字节的缓冲  
            while ((read = socketChannel.read(buffer)) != -1) {
                if (read == 0 && readed) {
                    break;
                } else if (read == 0) {
                    continue;
                }

                buffer.flip();// flip方法在读缓冲区字节操作之前调用。  
                System.out.println(charset.decode(buffer));
                // 使用Charset.decode方法将字节转换为字符串  
                buffer.clear();// 清空缓冲  
                readed = true;
            }
            System.out.println("----------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        sendHttpRequest();
    }


}  