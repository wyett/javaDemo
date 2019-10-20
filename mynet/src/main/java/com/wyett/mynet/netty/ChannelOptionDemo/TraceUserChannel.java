package com.wyett.mynet.netty.ChannelOptionDemo;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;
import java.net.InetSocketAddress;

/** * @author : wyettLei
 * @date : Created in 2019/9/4 15:33
 * @description: TODO
 */

public class TraceUserChannel {
    public void trace() {
        final AttributeKey<Integer> id = AttributeKey.newInstance("ID");
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new SimpleChannelInboundHandler<ByteBuf>() {
                    @Override
                    public void channelRegistered(ChannelHandlerContext ctx)
                    throws Exception{
                        // get attr value
                        Integer idValue = ctx.channel().attr(id).get();
                    }
                    @Override
                    protected void channelRead0(ChannelHandlerContext ctx,
                                                ByteBuf byteBuf)
                            throws Exception {
                        System.out.println("recevied data");
                    }
                });
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);
        ChannelFuture future = bootstrap.connect(
                new InetSocketAddress("xxxxx", 80));
        future.syncUninterruptibly();
    }
}
