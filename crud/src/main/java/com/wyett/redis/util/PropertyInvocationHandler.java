package com.wyett.redis.util;

import com.alibaba.druid.util.StringUtils;
import com.wyett.mysql.util.ReadConf;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/30 17:10
 * @description: TODO
 */

public class PropertyInvocationHandler implements InvocationHandler {
    private Properties properties;
    public PropertyInvocationHandler(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] obj) {
        ReadConf readConf = method.getAnnotation(ReadConf.class);
        System.out.println(readConf);

        if(readConf == null) {
            return null;
        }

        String value = readConf.value();
        String property = properties.getProperty(value);
        if(StringUtils.isEmpty(property)) {
            return null;
        }

        Class<?> returnClass = method.getReturnType();
        if(returnClass.isPrimitive()) {
            if (returnClass.equals(int.class)) { return Integer.valueOf(property); }
            if (returnClass.equals(long.class)) { return Long.valueOf(property); }
            if (returnClass.equals(float.class)) { return Float.valueOf(property); }
            if (returnClass.equals(double.class)) { return Double.valueOf(property); }
            if (returnClass.equals(boolean.class)) { return Boolean.valueOf(property); }
            if (returnClass.equals(short.class)) { return Short.valueOf(property); }
        } else {
            if (returnClass.equals(int.class)) { return Integer.valueOf(property); }
            if (returnClass.equals(String.class)) { return String.valueOf(property); }
            if (returnClass.equals(boolean.class)) { return Boolean.valueOf(property); }
        }
        return property;
    }
}
