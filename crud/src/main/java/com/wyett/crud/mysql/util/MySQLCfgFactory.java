package com.wyett.crud.mysql.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.util.Properties;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/30 12:00
 * @description: TODO
 */

public class MySQLCfgFactory {
    public MySQLCfgFactory() {}
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
