package com.wyett.mynet.netty.ByteBufDemo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Random;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/3 11:08
 * @description: TODO
 */

public class ByteBufHandler {
    public void randomAccessByteBuf() {
        ByteBuf buffer = Unpooled.buffer();
        for (int i = 0;i < buffer.capacity(); i++) {
            byte b = buffer.getByte(i);
            System.out.println((char)b);
        }
    }

    public void readAll() {
        ByteBuf buffer = Unpooled.buffer();
        while(buffer.isReadable()) {
            System.out.println(buffer.readByte());
        }
    }

    public void write() {
        ByteBuf buffer = Unpooled.buffer();
        Random rand = new Random(10);
        while(buffer.writableBytes() >= 4) {
            buffer.writeInt(rand.nextInt());
        }
    }


    public void copyByteBuf() {
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);
        ByteBuf copy = buf.copy(0, buf.capacity());
        System.out.println(copy.toString(utf8));
        // update charactor at pos 0
        buf.setByte(0, (byte)'J');
        assert buf.getByte(0) != copy.getByte(0);
    }



}
