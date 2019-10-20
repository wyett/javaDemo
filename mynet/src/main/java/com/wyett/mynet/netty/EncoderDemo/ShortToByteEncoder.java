package com.wyett.mynet.netty.EncoderDemo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageEncoder;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/4 19:59
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class ShortToByteEncoder extends MessageToByteEncoder<Short> {
    @Override
    public void encode(ChannelHandlerContext ctx,
                       Short msg, ByteBuf out) throws Exception {
        out.writeShort(msg);
    }
}
