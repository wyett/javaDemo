package com.wyett.crud.conf;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/30 15:59
 * @description: TODO
 * @modified By:
 * @version: $
 */

public interface MySQLCfgService {
    @ReadConf(value = "databasename")
    String getDatabaseName();

    @ReadConf(value = "readvip")
    String getReadVip();

    @ReadConf(value = "readuser")
    String getReadUser();

    @ReadConf(value = "readpassword")
    String getReadPassword();

    @ReadConf(value = "writevip")
    String getWriteVip();

    @ReadConf(value = "writeuser")
    String getWriteUser();

    @ReadConf(value = "writepassword")
    String getWritePassword();
}
