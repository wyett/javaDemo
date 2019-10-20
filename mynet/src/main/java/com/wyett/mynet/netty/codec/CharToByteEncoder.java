package com.wyett.mynet.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageEncoder;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/4 20:33
 * @description: TODO
 */

public class CharToByteEncoder extends MessageToByteEncoder<Character> {
    @Override
    public void encode(ChannelHandlerContext ctx,
                       Character msg, ByteBuf out) throws Exception {
        out.writeChar(msg);
    }
}
