package com.wyett.v3;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/25 17:51
 * @description: TODO
 */

public class ConfigResolve3 {
    public void readConf(String filename) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(filename);
        properties.load(inputStream);
        System.out.println(properties.getProperty("host"));
    }

    @Test
    public void test() {
        try {
            readConf("mysql.conf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
