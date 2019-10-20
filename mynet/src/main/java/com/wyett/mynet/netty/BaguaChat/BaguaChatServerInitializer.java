package com.wyett.mynet.netty.BaguaChat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

import javax.swing.event.ChangeListener;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/10 19:01
 * @description: TODO
 */

public class BaguaChatServerInitializer extends ChannelInitializer<Channel>{
    private final ChannelGroup group;

    public BaguaChatServerInitializer(ChannelGroup group) {
        this.group = group;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // HttpRequest/HttpContent/LastHttpContent
        pipeline.addLast(new HttpServerCodec());
        // handle large data
        pipeline.addLast(new ChunkedWriteHandler());
        // aggregate HttpMessage and HttpContents into FullHttpRequest or FullHttpContent
        pipeline.addLast(new HttpObjectAggregator(64 * 1024));
        // handler FullHttpRequest with "/ws"
        pipeline.addLast(new HttpRequestHandler("/ws"));
        // handle WebSocket handshake/ping/pong/close
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        // handle TextWebSocketFrame and handshake
        pipeline.addLast(new TextWebSocketFrameHandler(group));
    }
}
