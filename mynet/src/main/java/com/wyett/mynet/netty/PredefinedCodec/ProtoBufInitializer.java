package com.wyett.mynet.netty.PredefinedCodec;

import com.google.protobuf.MessageLite;
import io.netty.channel.*;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/10 14:33
 * @description: TODO
 */

public class ProtoBufInitializer extends ChannelInitializer<Channel>{
    private final MessageLite lite;

    public ProtoBufInitializer(MessageLite lite) {
        this.lite = lite;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new ProtobufVarint32FrameDecoder());
        pipeline.addLast(new ProtobufEncoder());
        pipeline.addLast(new ProtobufDecoder(lite));
        pipeline.addLast(new ObjectHandler());
    }

    public static final class ObjectHandler
    extends SimpleChannelInboundHandler<Object> {
        @Override
        public void channelRead0(ChannelHandlerContext ctx,
                                 Object msg) {
        }
    }
}
