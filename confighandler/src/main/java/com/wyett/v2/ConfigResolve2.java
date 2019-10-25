package com.wyett.v2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/25 16:52
 * @description: TODO
 */

public class ConfigResolve2 {
    private static void readConf(String filename) throws IOException {
        Properties properties = new Properties();
        ClassLoader classLoader = ConfigResolve2.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream(filename);
        properties.load(in);
        System.out.println(properties.getProperty("host"));

    }

    public static void main(String[] args) throws IOException {
        readConf("mysql.conf");
    }
}
