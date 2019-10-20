package com.wyett.mynet.netty.WriteIntoChannel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;


/**
 * @author : wyettLei
 * @date : Created in 2019/9/2 11:41
 * @description: TODO
 */

public class WriteIntoChannel {
    private String msg;
    public WriteIntoChannel(String msg) {
        this.msg = msg;
    }
    public void writeToChannel() {
        Channel channel = new NioServerSocketChannel();
        ByteBuf buf = Unpooled.copiedBuffer(msg, CharsetUtil.UTF_8);
        ChannelFuture cf = channel.writeAndFlush(buf);
        cf.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if(channelFuture.isSuccess()) {
                    System.out.println("Write successful");
                } else {
                    System.err.println("Write error");
                    channelFuture.cause().printStackTrace();
                }
            }
        });
    }
}
