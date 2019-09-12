package com.wyett.logevent.LogEventMonitor;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/11 20:17
 * @description: TODO
 */

public class LogEventDecoder extends MessageToMessageDecoder<DatagramPacket> {
    @Override
    protected void decode(ChannelHandlerContext ctx,
                          DatagramPacket datagramPacket,
                          List<Object> out) throws Exception {
        ByteBuf data = datagramPacket.content();
        // get index of LogEvent.SEPERATOR
        int idx = data.indexOf(0, data.readableBytes(), LogEvent.SEPARATOR);
        String filename = data.slice(0, idx).toString(CharsetUtil.UTF_8);
        String logMsg = data.slice(idx + 1,
                data.readableBytes()).toString(CharsetUtil.UTF_8);
        LogEvent event = new LogEvent(datagramPacket.sender(),
                System.currentTimeMillis(), filename, logMsg);
        out.add(event);
    }
}
