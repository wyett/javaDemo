package com.wyett.mynet.netty.PredefinedCodec;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/5 11:22
 * @description: TODO
 */

public class HttpPipelineInitializer extends ChannelInitializer<Channel> {
    // client or not
    private final boolean client;

    public HttpPipelineInitializer(boolean client) {
        this.client = client;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        if (client) {
            // for clent, decode response and encode request
            pipeline.addLast("decoder", new HttpResponseDecoder());
            pipeline.addLast("encoder", new HttpRequestEncoder());
        } else {
            // for server, encode response and decode request
            pipeline.addLast("encoder", new HttpRequestDecoder());
            pipeline.addLast("decoder", new HttpResponseEncoder());
        }
    }
}
