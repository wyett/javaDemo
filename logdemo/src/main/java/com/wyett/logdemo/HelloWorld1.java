package com.wyett.logdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author : wyettLei
 * @date : Created in 2019/10/16 11:30
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class HelloWorld1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorld1.class);

    public void helloWorld() {
        try {
            System.out.println("hello world");
            LOGGER.info("normal");
        } catch(Exception ex) {
            LOGGER.error(ex.toString());
        }
    }

}
