package com.wyett.crud.redis.util;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/25 10:01
 * @description: TODO
 */

public class RedisConfigDemo {
    private String configFile =
            "G:\\java\\javademo\\crud\\src\\main\\java\\com\\wyett\\crud\\redis\\conf" +
                    "\\redis.properties";
    @Test
    public void test() throws FileNotFoundException {
        InputStream redisStream = new FileInputStream(configFile);


        // print redisStream
        // 1
        /*Scanner scanner = new Scanner(redisStream);
        while(scanner.hasNext()) {
            System.out.println(scanner.next());
        }*/

        // 2
        /*int length = (int)configFile.length();
        byte[] newByte = new byte[length];
        try {
            redisStream.read(newByte);
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                redisStream.close();
            } catch (IOException ex) { }
        }
        System.out.println(new String(newByte));
        */


        RedisCfgService redisCfgService = RedisCfgFactory.readProperties(redisStream);

        if (redisCfgService == null) { return; }

        String host = redisCfgService.getHost();
        String port = redisCfgService.getPort();
        String password = redisCfgService.getPassword();

        System.out.println(host + "\n" + port + "\n" + password);
    }
}
