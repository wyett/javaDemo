package com.wyett.mynet.concurrencysocket.datamodel;

import java.io.Serializable;
import java.util.List;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/17 17:41
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class UserInfo implements Serializable {
    private String name;
    private String password;
    public UserInfo(String name, String password) {
        this.name = name;
        this.password = password;
    }
    @Override
    public String toString() {
        return "Name: " + name + ", Password: " + password;
    }
    // get name
    public String getName() {
        return this.name;
    }
    // get password
    public String getPassword() {
        return this.password;
    }
    // set name
    public void setName(String name) {
        this.name = name;
    }
    // set password
    public void setPassword(String password) {
        this.password = password;
    }
//    private String[] userInfo;
//    public UserInfo(String[] userInfo) {
//        this.userInfo = userInfo;
//    }
//    private List<String> userInfo;
//    public UserInfo(List<String> userInfo) {
//        this.userInfo = userInfo;
//    }
//    @Override
//    public String toString(){
//        return userInfo.toArray().toString();
//    }
}
