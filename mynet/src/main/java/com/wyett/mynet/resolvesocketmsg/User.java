package com.wyett.mynet.resolvesocketmsg;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/17 10:27
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class User implements java.io.Serializable{
    private String name;
    private String password;
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
