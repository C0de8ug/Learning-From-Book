package java_core.IO.NIO.Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIO {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        channel.bind(new InetSocketAddress("127.0.0.1", 8080));
        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            int readyChannels = selector.select();
            if (readyChannels == 0) continue;
            Set selectedKeys = selector.selectedKeys();
            Iterator keyIterator = selectedKeys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = (SelectionKey) keyIterator.next();
                if (key.isAcceptable()) {
                    System.out.println("a connection was accepted by a ServerSocketChannel.");
                    // a connection was accepted by a ServerSocketChannel.
                } else if (key.isConnectable()) {
                    System.out.println("a connection was established with a remote server.");
                    // a connection was established with a remote server.
                } else if (key.isReadable()) {
                    System.out.println("a channel is ready for reading");
                    // a channel is ready for reading
                } else if (key.isWritable()) {
                    System.out.println("a channel is ready for writing");
                    // a channel is ready for writing
                }
                keyIterator.remove();
            }
        }
    }
}
