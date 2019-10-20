package com.wyett.mynet.netty.BootstrapServer;

import com.sun.security.ntlm.Server;
import io.netty.bootstrap.Bootstrap;
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
 * @date : Created in 2019/9/4 14:30
 * @description:
 */

public class ChannelBootstrapServer {
    public void channelBsServer() {
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(new NioEventLoopGroup(), new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(new SimpleChannelInboundHandler<ByteBuf>() {
                    ChannelFuture connectFuture;
                    @Override
                    public void channelActive(ChannelHandlerContext ctx)
                        throws Exception {
                        Bootstrap bootstrap = new Bootstrap();
                        bootstrap.channel(NioSocketChannel.class)
                                .handler(new SimpleChannelInboundHandler<ByteBuf>() {
                                    @Override
                                    protected void channelRead0(
                                            ChannelHandlerContext ctx,
                                            ByteBuf byteBuf) throws Exception {
                                        System.out.println("");
                                    }
                                });
                        // link bootstrap to Server EventLootGroup
                        bootstrap.group(ctx.channel().eventLoop());
                        connectFuture = bootstrap.connect(
                                new InetSocketAddress("", 80));
                    }
                    @Override
                    public void channelRead0(ChannelHandlerContext ctx,
                                             ByteBuf byteBuf) throws Exception {
                        if(connectFuture.isDone()) {
                            //
                        }
                    }

                });
        // bind
        ChannelFuture future = bootstrap.bind(new InetSocketAddress(8080));
        // add Listener on channelFuture
        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if(channelFuture.isSuccess()) {
                    System.out.println();
                } else {
                    System.out.println();
                    channelFuture.cause().printStackTrace();
                }
            }
        });
    }
}
















