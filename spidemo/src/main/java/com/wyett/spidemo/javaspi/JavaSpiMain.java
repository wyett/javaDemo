package com.wyett.spidemo.javaspi;

import java.util.ServiceLoader;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/16 14:44
 * @description: TODO
 */

public class JavaSpiMain {
    public static void main(String[] args) {
        ServiceLoader<DriverSevice> serviceLoader =
                ServiceLoader.load(DriverSevice.class);
        for(DriverSevice driverSevice : serviceLoader) {
            System.out.println(driverSevice.getName());
        }
    }
}
