package com.wyett.crud.redis.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.util.Properties;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/30 12:00
 * @description: TODO
 */

public class RedisCfgFactory {
    public RedisCfgFactory() {}
    public static RedisCfgService readProperties(final InputStream inputStream) {
        final Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            return null;
        }
        return (RedisCfgService) Proxy.newProxyInstance(
                RedisCfgService.class.getClassLoader(),
                new Class[] { RedisCfgService.class },
                new PropertyInvocationHandler(properties));
    }
}
