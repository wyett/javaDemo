package com.wyett.mynet.netty.EncoderDemo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/4 20:06
 * @description: TODO
 */

public class IntegerToStringEncoder extends MessageToMessageEncoder<Integer> {
    @Override
    public void encode(ChannelHandlerContext ctx,
                       Integer msg, List<Object> out) throws Exception {
        out.add(String.valueOf(msg));
    }
}
