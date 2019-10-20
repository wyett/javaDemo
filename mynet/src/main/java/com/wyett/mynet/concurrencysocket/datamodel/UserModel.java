package com.wyett.mynet.concurrencysocket.datamodel;

import com.wyett.mynet.concurrencysocket.datadecorator.DecoratorImpl;
import com.wyett.mynet.concurrencysocket.datadecorator.StringModifyDecorator;

import java.io.Serializable;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/23 11:55
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class UserModel extends StringModifyDecorator implements Serializable {
    private String name;
    private String password;
    public UserModel(DecoratorImpl decoratorImpl,
                     String name, String password) {
        super(decoratorImpl);
        this.name = name;
        this.password = password;
    }
    @Override
    public String toString() {
        return "Name: " + name + ", Password: " + password;
    }
//    // get name
//    public String getName() {
//        return this.name;
//    }
//    // get password
//    public String getPassword() {
//        return this.password;
//    }
//    // set name
//    public void setName(String name) {
//        this.name = name;
//    }
//    // set password
//    public void setPassword(String password) {
//        this.password = password;
//    }
    public String getName() {
        return super.decrypt(this.name);
    }
    public String getPassword() {
        return super.decrypt(this.password);
    }
    public void setName(String name) {
        this.name = super.encrypt(name);
    }
    public void setPassword(String password) {
        this.password = super.encrypt(password);
    }
}
