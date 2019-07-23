package mynet.concurrencysocket.datadecorator;

import mynet.concurrencysocket.datamodel.UserInfo;
import java.util.regex.Pattern;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/18 17:24
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class UserInfoAddStringDecorator
        extends UserInfo implements DecoratorImpl {
    private String key = "_new";
    public UserInfoAddStringDecorator(String name, String password) {
        super(name, password);
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
    @Override
    public String toString() {
        return super.toString();
    }
//    private List<String> encryptFields(String user, String password) {
//        List<String> userInfoList = Arrays.asList(user, password);
//        return userInfoList.stream()
//                .map(fieldStr -> encrypt(fieldStr))
//                .collect(Collectors.toList());
//    }
//    private List<String> decryptFields(String user, String password) {
//        List<String> userInfoList = Arrays.asList(user, password);
//        return userInfoList.stream()
//                .map(fieldStr -> decrypt(fieldStr))
//                .collect(Collectors.toList());
//    }
//    private void encryptFields(String name, String password) {
//        super.name = encrypt(name);
//        super.password = encrypt(password);
//    }
//    private void decryptFields() {
//        decrypt(getName());
//        decrypt(getPassword());
//    }
}
