package com.wyett.mynet.concurrencysocket.datadecorator;

import com.wyett.mynet.concurrencysocket.datamodel.TalkModel;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/23 19:29
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class TalkModelAddStringDecorator
        extends TalkModel implements DecoratorImpl {
    private final String key = "_new";
    public TalkModelAddStringDecorator(String talkStr) {
        super(talkStr);
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
        boolean isMatched = Pattern.matches(mark, oStr);
        String[] tmpStr = {};
        if(isMatched) {
            tmpStr = oStr.split(mark);
            System.out.println(tmpStr[0]);
        }
        return tmpStr[pos];
    }
    public void encryptField(String str) {
        super.setTalkStr(encrypt(str));
    }
    public String decryptField() {
        return decrypt(super.getTalkStr());
    }
}
