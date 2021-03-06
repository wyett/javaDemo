package com.wyett.logevent;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;
import io.netty.channel.socket.DatagramPacket;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/11 17:59
 * @description: TODO
 */

public class LogEventEncoder extends MessageToMessageEncoder<LogEvent> {
    private final InetSocketAddress remoteAddress;

    public LogEventEncoder(InetSocketAddress remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx,
                          LogEvent logEvent, List<Object> out) throws Exception {
        byte[] msg = logEvent.getMsg().getBytes(CharsetUtil.UTF_8);
        byte[] file = logEvent.getLogfile().getBytes(CharsetUtil.UTF_8);
        ByteBuf buf = ctx.alloc().buffer(file.length + msg.length + 1);
        buf.writeBytes(file);
        buf.writeByte(LogEvent.SEPARATOR);
        buf.writeBytes(msg);
        out.add(new DatagramPacket(buf, remoteAddress));
    }

}
