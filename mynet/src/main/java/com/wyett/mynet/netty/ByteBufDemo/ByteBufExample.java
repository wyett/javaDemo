package com.wyett.mynet.netty.ByteBufDemo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.ByteBuffer;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/2 17:56
 * @description: TODO
 */

public class ByteBufExample {
    public void heapBufHandler() {
        ByteBuf heapBuf = Unpooled.buffer(10);
        if(heapBuf.hasArray()) {
            // get
            byte[] array = heapBuf.array();
            // get offset
            int offset = heapBuf.arrayOffset() + heapBuf.readerIndex();
            // get readableOffset
            int length = heapBuf.readableBytes();
            handleArray(array, offset, length);
        }
    }

    public void directBufHandler() {
        ByteBuf directBuf = Unpooled.buffer(10);
        if(!directBuf.hasArray()) {
            int length = directBuf.readableBytes();
            byte[] array = new byte[length];
            directBuf.getBytes(directBuf.readerIndex(), array);
            handleArray(array, 0, length);
        }
    }

    public void byteBufferHandler(ByteBuffer header, ByteBuffer body) {
        ByteBuffer[] message = new ByteBuffer[] {header, body};
        ByteBuffer message2 =
                ByteBuffer.allocate(header.remaining() + body.remaining());
        message2.put(header);
        message2.put(body);
        message2.flip();
    }

    public void compositeByteBufHandler() {
        CompositeByteBuf msgBuf = Unpooled.compositeBuffer();
        ByteBuf headerBuf = Unpooled.buffer();
        ByteBuf bodyBuf = Unpooled.buffer();
        msgBuf.addComponents(headerBuf, bodyBuf);
        msgBuf.removeComponent(0);
        for(ByteBuf buf : msgBuf) {
            System.out.println(buf.toString());
        }
    }

    public void readCompositeByteBuf() {
        CompositeByteBuf compBuf = Unpooled.compositeBuffer();
        int length = compBuf.readableBytes();
        byte[] array = new byte[length];
        compBuf.getBytes(compBuf.readerIndex(), array);
        handleArray(array, 0, array.length);
    }

    public void handleArray(byte[] obj, int start, int len) {

    }

}
