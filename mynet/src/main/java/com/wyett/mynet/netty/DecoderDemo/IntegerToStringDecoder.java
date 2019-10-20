package com.wyett.mynet.netty.DecoderDemo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/4 19:25
 * @description: TODO
 */

public class IntegerToStringDecoder extends MessageToMessageDecoder<Integer> {
    @Override
    public void decode(ChannelHandlerContext ctx,
                       Integer msg, List<Object> out) throws Exception {
        out.add(String.valueOf(msg));
    }
}
