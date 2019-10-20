package com.wyett.mynet;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import static com.wyett.util.Print.print;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/15 21:04
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            InetAddress ia1 = InetAddress.getByName("www.qq.com");
            System.out.println(ia1.getHostName());
            System.out.println(ia1.getHostAddress());
        } catch(UnknownHostException e) {
            e.printStackTrace();
        }
        print("test2==============");
        try {
            InetAddress ia2 = InetAddress.getByName("61.135.169.106");
            print(ia2.getHostName());
            print(ia2.getHostAddress());
        } catch(UnknownHostException e) {
            e.printStackTrace();
        }
        print("test3==============");
        try {
            InetAddress ia3 = InetAddress.getLocalHost();
            print("hostname: " + ia3.getHostName());
            print("local host ip: " + ia3.getHostAddress());
        } catch(UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
