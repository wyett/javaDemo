package com.wyett.mynet.netty.PredefinedCodec;

import io.netty.channel.*;
import io.netty.handler.codec.marshalling.MarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallingDecoder;
import io.netty.handler.codec.marshalling.MarshallingEncoder;
import io.netty.handler.codec.marshalling.UnmarshallerProvider;
import io.netty.handler.codec.serialization.ObjectDecoder;

import java.io.Serializable;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/10 11:52
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class MarshallingInitializer extends ChannelInitializer<Channel>{
    private final MarshallerProvider marshallerProvider;
    private final UnmarshallerProvider unMarshallerProvider;

    public MarshallingInitializer(MarshallerProvider marshallerProvider,
                                  UnmarshallerProvider unMarshallerProvider) {
        this.marshallerProvider = marshallerProvider;
        this.unMarshallerProvider = unMarshallerProvider;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new MarshallingDecoder(unMarshallerProvider));
        pipeline.addLast(new MarshallingEncoder(marshallerProvider));
        pipeline.addLast(new ObjectHandler());
    }

    public static final class ObjectHandler
    extends SimpleChannelInboundHandler<Serializable> {
        @Override
        public void channelRead0(ChannelHandlerContext ctx, Serializable serializable)
        throws Exception {

        }
    }

}
