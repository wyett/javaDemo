package com.wyett.mynet.netty.WriteIntoChannel;

import org.junit.jupiter.api.Test;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/2 15:51
 * @description: TODO
 */

public class WriteIntoChannelDemo {
    @Test
    public static void test(String[] args) {
        WriteIntoChannel wic = new WriteIntoChannel("hello");
        wic.writeToChannel();
    }
}
