package com.wyett.mynet.netty.codec;

import io.netty.channel.CombinedChannelDuplexHandler;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/4 20:36
 * @description: TODO
 */

public class CombinedByteCharCodec extends
        CombinedChannelDuplexHandler<ByteToCharDecoder, CharToByteEncoder> {
    public CombinedByteCharCodec() {
        super(new ByteToCharDecoder(), new CharToByteEncoder());
    }
}
