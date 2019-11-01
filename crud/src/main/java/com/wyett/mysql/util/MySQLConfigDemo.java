package com.wyett.mysql.util;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/30 18:14
 * @description: TODO
 */

public class MySQLConfigDemo {
    @Test
    public void test() throws Exception{
        try {
            InputStream mysqlStream = new FileInputStream
                    ("G:\\java\\javademo\\crud\\src\\main\\java\\com\\wyett\\crud" +
                            "\\mysql\\conf\\mysql.properties");
            MySQLCfgService mySQLCfgService = MySQLCfgFactory.readProperties(mysqlStream);
            if (mySQLCfgService == null) {
                return;
            }
            String writevip= mySQLCfgService.getWriteVip();
            String readvip= mySQLCfgService.getReadVip();
            String writePassword = mySQLCfgService.getWritePassword();
            String readpassword = mySQLCfgService.getReadPassword();
            String databasename = mySQLCfgService.getDatabaseName();
            System.out.println(writevip + "\n" +
                                readvip + "\n"
                            + writePassword + "\n"
                            + readpassword + "\n"
                            + databasename + "\n");
        } catch (FileNotFoundException e) {
            System.out.println("mysqlconfig not found");
        }
    }
}
