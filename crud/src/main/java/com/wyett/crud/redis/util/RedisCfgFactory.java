package com.wyett.crud.redis.util;

import com.wyett.crud.mysql.util.MySQLCfgService;
import com.wyett.crud.mysql.util.PropertyInvocationHandler;

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
    public static MySQLCfgService readProperties(final InputStream inputStream) {
        final Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            return null;
        }
        return (MySQLCfgService) Proxy.newProxyInstance(
                MySQLCfgService.class.getClassLoader(),
                new Class[] { MySQLCfgService.class },
                new PropertyInvocationHandler(properties));
    }
}
