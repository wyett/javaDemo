package com.wyett.v4;

import org.junit.Test;

import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/25 18:10
 * @description: TODO
 */

public class ConfigResolve4 {
    private void readConf(String filename) throws MissingResourceException {
        Properties properties = new Properties();
        ResourceBundle resourceBundle = ResourceBundle.getBundle(filename);
        Enumeration<String> keyItem = resourceBundle.getKeys();
        while(keyItem.hasMoreElements()) {
            System.out.println(properties.getProperty(keyItem.nextElement()));
        }
    }

    @Test
    public void test() throws MissingResourceException {
        readConf("mysql.conf");
    }
}
