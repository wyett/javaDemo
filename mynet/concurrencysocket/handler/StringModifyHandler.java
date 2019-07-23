package mynet.concurrencysocket.handler;

import mynet.concurrencysocket.datadecorator.DecoratorImpl;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/23 12:05
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class StringModifyHandler implements DecoratorImpl{
    private String key;
    public StringModifyHandler(String key) {
        this.key = key;
    }
    @Override
    public String encrypt(String str) {
        return str + key;
    }
    @Override
    public String decrypt(String str) {
        return splitString(str, key, 0);
    }
    private static String splitString(String oStr, String mark, int pos) {
        System.out.println(oStr);
        boolean isMatched = Pattern.matches(mark, oStr);
        String[] tmpStr = {};
        if(isMatched) {
            tmpStr = oStr.split(mark);
        }
        System.out.println(Arrays.toString(tmpStr));
        return tmpStr[pos];
    }
}
