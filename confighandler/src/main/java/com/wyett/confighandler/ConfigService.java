package com.wyett.confighandler;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/18 19:40
 * @description: TODO
 */

public interface ConfigService {
    @ReadConf("host")
    String getHost();

    @ReadConf("user")
    String getUser();

    @ReadConf("password")
    String getPassword();

    @ReadConf("port")
    Integer getPort();

    @ReadConf("databasename")
    String getDbname();
}
