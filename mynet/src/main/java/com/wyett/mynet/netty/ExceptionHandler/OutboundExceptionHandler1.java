package com.wyett.mynet.netty.ExceptionHandler;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/3 18:01
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class OutboundExceptionHandler1 {
    private ChannelHandlerContext ctx;
    public OutboundExceptionHandler1(ChannelHandlerContext ctx) {
        this.ctx = ctx;
    }
    public ChannelFuture createChannelFuture(String msg) {
        ChannelFuture future = ctx.channel().write(msg);
        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture f) throws Exception {
                if(!f.isSuccess()) {
                    f.cause().printStackTrace();
                    f.channel().close();
                }
            }
        });
        return future;
    }
}
