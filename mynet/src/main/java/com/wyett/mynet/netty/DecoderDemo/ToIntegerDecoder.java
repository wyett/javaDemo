package com.wyett.mynet.netty.DecoderDemo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/4 19:03
 * @description: TODO
 */

public class ToIntegerDecoder extends ByteToMessageDecoder {
    private static final int INTSIZE = 4;
    @Override
    public void decode(ChannelHandlerContext ctx,
                       ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() >= INTSIZE) {
            out.add(in.readInt());
        }
    }
}
