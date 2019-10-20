package com.wyett.mynet.netty.BootstrapClient;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/4 11:12
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class BootstrapClient {
    public void btClient() {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new SimpleChannelInboundHandler<ByteBuf>() {
                    @Override
                    protected void channelRead0(
                            ChannelHandlerContext ctx,
                            ByteBuf byteBuf) throws Exception {
                        System.out.println("received data");
                    }
                });

        ChannelFuture future = bootstrap.connect(
                new InetSocketAddress("10.2.212.54", 80));

        future.addListener((ChannelFuture f) -> {
                if (f.isSuccess()) {
                    System.out.println("Connection established");
                } else {
                    System.err.println("Connection attempt failed");
                    f.cause().printStackTrace();
                }
            });
    }
}
