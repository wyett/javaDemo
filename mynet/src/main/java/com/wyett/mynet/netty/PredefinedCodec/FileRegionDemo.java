package com.wyett.mynet.netty.PredefinedCodec;

import io.netty.channel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.NoSuchFileException;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/10 11:06
 * @description: TODO
 */

public class FileRegionDemo {
    public void fileRegionDemo(Channel channel, File file) throws FileNotFoundException{
        FileInputStream in = new FileInputStream(file);
        FileRegion region = new DefaultFileRegion(
                in.getChannel(), 0, file.length());
        channel.writeAndFlush(region).addListener(
                new ChannelFutureListener() {
                    @Override
                    public void operationComplete(ChannelFuture future)
                    throws Exception {
                        if(!future.isSuccess()) {
                            Throwable cause = future.cause();
                        }
                    }
                }
        );
    }
}
