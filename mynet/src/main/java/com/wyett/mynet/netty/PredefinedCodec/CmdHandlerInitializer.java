package com.wyett.mynet.netty.PredefinedCodec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.handler.codec.LineBasedFrameDecoder;

import java.nio.ByteBuffer;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/5 20:08
 * @description: Cmd
 *               1. inputstream consist of an mount of frame deviced by '\n'
 *               2. frame consists of a mount of element splited by single space
 *               3. a frame consists of a command str and some args
 */

public class CmdHandlerInitializer extends ChannelInitializer<Channel> {
    static final byte SPACE = (byte)' ';
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new CmdDecoder(64 * 1024));
        pipeline.addLast(new CmdHandler());
    }

    // Cmd POJO
    public static final class Cmd {
        private final ByteBuf name;
        private final ByteBuf args;

        public Cmd(ByteBuf name, ByteBuf args) {
            this.name = name;
            this.args = args;
        }

        public ByteBuf name() {
            return name;
        }

        public ByteBuf args() {
            return args;
        }
    }

    public static final class CmdDecoder extends LineBasedFrameDecoder {
        public CmdDecoder(int maxLength) {
            super(maxLength);
        }

        @Override
        protected Object decode(ChannelHandlerContext ctx, ByteBuf buffer)
        throws Exception {
            // decode from ByteBuf
            ByteBuf frame = (ByteBuf) super.decode(ctx, buffer);
            if (frame == null) {
                return null;
            }
            // get index of the first SPACE symbol
            int index = frame.indexOf(frame.readerIndex(),
                    frame.writerIndex(), SPACE);
            return new Cmd(frame.slice(frame.readerIndex(), index),
                    frame.slice(index + 1, frame.writerIndex()));
        }
    }

    public static final class CmdHandler
    extends SimpleChannelInboundHandler <Cmd> {
        @Override
        public void channelRead0(ChannelHandlerContext ctx, Cmd msg)
        throws Exception {

        }
    }
}









