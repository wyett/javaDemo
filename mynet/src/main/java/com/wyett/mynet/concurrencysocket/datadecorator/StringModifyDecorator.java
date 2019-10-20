package com.wyett.mynet.concurrencysocket.datadecorator;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/23 12:03
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class StringModifyDecorator implements DecoratorImpl{
    private DecoratorImpl decoratorImpl;
    public StringModifyDecorator(DecoratorImpl decoratorImpl) {
        this.decoratorImpl = decoratorImpl;
    }
    @Override
    public String encrypt(String str) {
        return decoratorImpl.encrypt(str);
    }
    @Override
    public String decrypt(String str) {
        return decoratorImpl.decrypt(str);
    }
}
