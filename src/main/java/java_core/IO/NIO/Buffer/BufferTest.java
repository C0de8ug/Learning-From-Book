package java_core.IO.NIO.Buffer;

import sun.nio.ch.DirectBuffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BufferTest {
    public static void main(String[] args) {
        Buffer buffer = ByteBuffer.allocate(100);
        Buffer directBuffer = ByteBuffer.allocateDirect(100);

    }
}
