package com.wyett.v1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/25 16:21
 * @description: TODO
 */

public class ConfigResolve {
    public Properties getProp(String filename) throws FileNotFoundException{
        InputStream inputStream = new FileInputStream(filename);
        Properties properties = new Properties();

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties;
    }

    public static void main(String[] args) throws FileNotFoundException{
        String configFile =
            "G:\\java\\javademo\\confighandler\\src\\main\\java" +
            "\\conf\\mysql.conf";

        ConfigResolve cr = new ConfigResolve();
        Properties properties = cr.getProp(configFile);
        String host = properties.getProperty("host");
        String port = properties.getProperty("port");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String dbname = properties.getProperty("databasename");

        System.out.println(host + ":" + port
                + ":" + user + ":" + password + ":" + dbname);
    }
}
