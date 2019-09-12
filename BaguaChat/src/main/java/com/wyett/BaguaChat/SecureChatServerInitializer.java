package com.wyett.BaguaChat;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLEngine;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/11 16:08
 * @description: TODO
 */

public class SecureChatServerInitializer extends BaguaChatServerInitializer {
    private final SslContext context;

    public SecureChatServerInitializer(ChannelGroup group,
                                       SslContext context) {
        super(group);
        this.context = context;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        super.initChannel(ch);
        SSLEngine engine = context.newEngine((ch.alloc()));
        engine.setUseClientMode(false);
        ch.pipeline().addFirst(new SslHandler(engine));
    }
}
