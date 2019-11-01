package com.wyett.redis.util;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/24 19:13
 * @description: TODO
 */

public interface RedisCfgService {
    @ReadConf(value = "host")
    String getHost();

    @ReadConf(value = "port")
    String getPort();

    @ReadConf(value = "password")
    String getPassword();

}
