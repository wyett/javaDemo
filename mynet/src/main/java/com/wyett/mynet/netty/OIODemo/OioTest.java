package com.wyett.mynet.netty.OIODemo;

import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/30 11:24
 * @description: TODO
 */

public class OioTest {
    @Test
    public void test() throws IOException{
        new PlainOioServer().serve(10000);
    }
}
