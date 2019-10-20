package com.wyett.mynet.netty.BootstrapServer;

import com.sun.security.ntlm.Server;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/4 11:43
 * @description: TODO
 */

public class BootstrapServer {
    public void bsServer() {
        NioEventLoopGroup group = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(group)
                .channel(NioServerSocketChannel.class)
                .childHandler(new SimpleChannelInboundHandler<ByteBuf>() {
                    @Override
                    protected void channelRead0(
                            ChannelHandlerContext ctx,
                            ByteBuf byteBuf) throws Exception {
                        System.out.println("received data");
                    }
                });

        ChannelFuture future = bootstrap.bind(new InetSocketAddress(8080));
        future.addListener((ChannelFuture f) -> {
                if(f.isSuccess()) {
                    System.out.println("Server bound");
                } else {
                    System.out.println("Bound attempt failed");
                    f.cause().printStackTrace();
                }
        });
    }
}
