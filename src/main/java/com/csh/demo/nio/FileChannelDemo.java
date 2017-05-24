package com.csh.demo.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用FileChannel读取数据到Buffer中的示例
 * @author chenshenghong
 * @version 1.0
 * @created 2017/5/20
 * @time 下午12:17
 */
public class FileChannelDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile =
                new RandomAccessFile("/Users/csh/workspace/java-demo/src/main/resources/file/nio-data.txt", "rw");
        FileChannel channel = aFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        int read = channel.read(buffer);//写入 buffer
        while (read != -1) {
            System.out.println("Read " + read);
            //首先读取数据到Buffer，然后flip 反转Buffer,接着再从Buffer中读取数据
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println(Byte.toString(buffer.get()));
            }

            buffer.clear();
            int bytesRead = channel.read(buffer);
        }
    }
}
