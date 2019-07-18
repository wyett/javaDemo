package mynet.concurrencysocket.datamodel;

import java.io.Serializable;

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

//    transfer func
//    public static void main(String[] args) {
//        UserModel userModel = (str)->{
//            String[] tmpStr = str.split("_new");
//            return tmpStr[0];
//        };
//        decode(userModel);
//    }
//    public static void decode(UserInfo userInfo) {
//        List<String> ls = new ArrayList<String>();
//        ls.add(userInfo.getName());
//        ls.add(userInfo.getPassword());
//        ls.stream().forEach(userInfo::decrypt);
//    }
}
