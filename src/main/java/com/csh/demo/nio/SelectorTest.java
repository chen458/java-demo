package com.csh.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: shenghong.chen
 * Date: 2017/3/19
 * time: 下午10:26
 */
public class SelectorTest {
    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);//非阻塞
        ssc.socket().bind(new InetSocketAddress(8080));//发送端口
        ssc.register(selector, SelectionKey.OP_ACCEPT);//注册监听事件
        while (true) {
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
                    ServerSocketChannel channel =(ServerSocketChannel) key.channel();
                    SocketChannel sc = channel.accept();//接收服务端的请求
                    sc.configureBlocking(false);
                    sc.register(selector, SelectionKey.OP_READ);
                    iterator.remove();
                } else if ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
                    SocketChannel channel =(SocketChannel) key.channel();
                    while (true) {
                        buffer.clear();
                        int read = channel.read(buffer);
                        if (read <= 0) {
                            break;
                        }
                        buffer.flip();
                    }
                    iterator.remove();;
                }


            }
        }



    }
}
