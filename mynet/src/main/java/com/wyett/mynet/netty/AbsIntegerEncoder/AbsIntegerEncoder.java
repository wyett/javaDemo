package com.wyett.mynet.netty.AbsIntegerEncoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/4 17:24
 * @description: TODO
 */

public class AbsIntegerEncoder extends MessageToMessageEncoder<ByteBuf> {
    @Override
    protected void encode(ChannelHandlerContext ctx,
                          ByteBuf in, List<Object> out) throws Exception {
        while(in.readableBytes() >= 4) {
            int value = Math.abs(in.readInt());
            out.add(value);
        }
    }
}
