package com.wyett.mynet.netty.FixedLengthFrameDecoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/4 16:25
 * @description: TODO
 */

public class FixedLengthFrameDecoder extends ByteToMessageDecoder {
    private final int framelength;
    public FixedLengthFrameDecoder(int framelength) {
        if (framelength <= 0) {
            throw new IllegalArgumentException(
                    "frameLeghth must be a positive integer: " + framelength);
        }
        this.framelength = framelength;
    }
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object>
            out) throws Exception {
        while (in.readableBytes() >= framelength) {
            ByteBuf buf = in.readBytes(framelength);
            out.add(buf);
        }
    }
}
