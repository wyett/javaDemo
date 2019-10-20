package com.wyett.mynet.netty.MutilThreadOneChannel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/2 16:00
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class MutilThreadOneChannel {
    private String msg;
    public void writeToOneChannel() {
        final Channel channel = new NioServerSocketChannel();
        final ByteBuf buf = Unpooled.copiedBuffer(msg,
                CharsetUtil.UTF_8).retain();
        Runnable writer = new Runnable() {
            @Override
            public void run() {
                channel.writeAndFlush(buf.duplicate());
            }
        };

        Executor executor = Executors.newCachedThreadPool();
        executor.execute(writer);
        executor.execute(writer);
    }
}
