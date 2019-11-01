package com.wyett.redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/22 15:52
 * @description: TODO
 */

public class OrderCache {
    public static Jedis connRedis(String host, int port, String pass) {
        Jedis jedis = null;
        try {
            jedis = new Jedis(host, port);
            jedis.auth(pass);
            System.out.println("connect sucessfully");
        } catch(Exception e) {
            System.out.println("connect failed");
            e.printStackTrace();
        }

        return jedis;
    }


    public static void hmsetJedis(String key, Map<String, String> hash) {

    }

    public static HashMap<String, String> createHashMap(String orderId,
                                                        String money,
                                                        String time) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("orderId", orderId);
        hashMap.put("money", money);
        hashMap.put("time", time);

        return hashMap;
    }

    /*public List<String> getUserOrderKeyByUserId(int userId) {
        List<String> ls = new ArrayList<>();



    }*/

    public static void main(String[] args) {

        //connect
        Jedis conn = connRedis("10.18.56.30", 6379, "12345678");

        //hmset
        conn.hmset("order:1", createHashMap("1", "36.6", "2018-01-01"));
        conn.hmset("order:2", createHashMap("2", "38.6", "2018-01-01"));
        conn.hmset("order:3", createHashMap("3", "39.6", "2018-01-01"));

        //lpush
        conn.lpush("user:1:order", "order:1");
        conn.lpush("user:1:order", "order:2");
        conn.lpush("user:1:order", "order:3");


        conn.hmset("order:4", createHashMap("4", "40.6", "2018-01-01"));
        conn.lpush("user:1:order", "order:4");

        //
    }
}
