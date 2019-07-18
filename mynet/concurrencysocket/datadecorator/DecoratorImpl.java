package mynet.concurrencysocket.datadecorator;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/17 19:26
 * @description: TODO
 * @modified By:
 * @version: $
 */

public interface DecoratorImpl{
    String encrypt(String str);
    String decrypt(String str);
}
