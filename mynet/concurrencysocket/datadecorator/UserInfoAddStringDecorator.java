package mynet.concurrencysocket.datadecorator;

import mynet.concurrencysocket.datamodel.UserInfo;
import java.util.regex.Pattern;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/18 17:24
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class UserInfoAddStringDecorator
        extends UserInfo implements DecoratorImpl {
    private static final String key = "_new";
    public UserInfoAddStringDecorator(String user, String password) {
        super(user, password);
    }
    @Override
    public String encrypt(String str) {
        return str + key;
    }
    @Override
    public String decrypt(String str) {
        return splitString(str, key, 0);
    }
    public String splitString(String oStr, String mark, int pos) {
        boolean isMatched = Pattern.matches(mark, oStr);
        String[] tmpStr = {};
        if(isMatched) {
            tmpStr = oStr.split(mark);
        }
        return tmpStr[0];
    }
}
