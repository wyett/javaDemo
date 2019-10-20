package com.wyett.mynet.netty.DecoderDemo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/4 19:15
 * @description: TODO
 */

public class ToIntegerDecoder2 extends ReplayingDecoder<ByteBuf> {
    @Override
    public void decode(ChannelHandlerContext ctx,
                       ByteBuf in, List<Object> out) throws Exception {
        out.add(in.readInt());
    }
}
