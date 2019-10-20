package com.wyett.mynet.netty.NioDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/30 11:43
 * @description: TODO
 */

public class PlainNioServer {
    public void serve(int port) throws IOException {
        // open channel
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);

        // create socket
        ServerSocket ssocket = ssc.socket();
        InetSocketAddress address = new InetSocketAddress(port);
        ssocket.bind(address);

        // create selector
        Selector selector = Selector.open();
        // register ssc on selector
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        //create new bytebuffer
        final ByteBuffer msg =
                ByteBuffer.wrap("Hi!\r\n".getBytes("UTF-8"));

        for(;;) {
            try {
                // blocking, and waiting for next case
                selector.select();
            } catch (IOException ex) {
                ex.printStackTrace();
                break;
            }

            // receive all selectedKeys
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readyKeys.iterator();
            while(iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();

                try {
                    // check if is acceptable
                    if(key.isAcceptable()) {
                        ServerSocketChannel server =
                                (ServerSocketChannel) key.channel();
                        SocketChannel client = server.accept();
                        client.configureBlocking(false);
                        // accept and register
                        client.register(selector, SelectionKey.OP_WRITE |
                            SelectionKey.OP_READ, msg.duplicate());
                        System.out.println(
                                "Accepted connection from " + client);
                    }
                    // check if writable
                    if (key.isWritable()) {
                        SocketChannel client =
                                (SocketChannel) key.channel();
                        ByteBuffer buffer =
                                (ByteBuffer) key.attachment();
                        while (buffer.hasRemaining()) {
                            if (client.write(buffer) == 0) {
                                break;
                            }
                        }
                        client.close();
                    }
                } catch(IOException ex) {
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (IOException cex) {

                    }
                }
            }
        }



    }
}
