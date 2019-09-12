package com.wyett.BaguaChat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/10 17:41
 * @description: TODO
 */

public class TextWebSocketFrameHandler
extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    private final ChannelGroup group;

    public TextWebSocketFrameHandler(ChannelGroup group) {
        this.group = group;
    }

    /**
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx,
                                   Object evt) throws Exception {
        if (evt == WebSocketServerProtocolHandler.HandshakeComplete.class) {
            // if handshake complete, remove httpRequestHandler from ChannelPipeline
            ctx.pipeline().remove(HttpRequestHandler.class);
            // notify all client connectting to WebSocket that new client has
            // connect
            group.writeAndFlush(new TextWebSocketFrame(
                    "Client " + ctx.channel() + " jointed"));
            // add new channel to ChannelGroup
            group.add(ctx.channel());
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx,
                             TextWebSocketFrame msg) throws Exception {
        // msg.retain() and write it to all client
        group.writeAndFlush(msg.retain());
    }
}
