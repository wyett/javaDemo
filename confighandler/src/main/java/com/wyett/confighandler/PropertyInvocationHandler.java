package com.wyett.confighandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/18 19:49
 * @description: TODO
 */

public class PropertyInvocationHandler implements InvocationHandler {
    Properties properties = new Properties();

    public PropertyInvocationHandler(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Object invoke(Object o, Method m, Object[] args) throws Throwable {

    }
}
