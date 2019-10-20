package com.wyett.mynet.netty.ExceptionHandler;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/3 17:56
 * @description: TODO
 */

public class OutboundExecptionHandler extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg,
                      ChannelPromise promise) {
        promise.addListener((ChannelFuture f) -> {
            if(!f.isSuccess()) {
                f.cause().printStackTrace();
                f.channel().close();
            }
        });
    }
}
