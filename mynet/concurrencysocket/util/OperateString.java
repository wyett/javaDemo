package mynet.concurrencysocket.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/18 16:32
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class OperateString {
    private String str;
    private String keyStr;
    private int strPos;
    private int count;
    public OperateString() {}
    public OperateString(String str) {
        this.str = str;
    }
    public OperateString(String str, String keyStr) {
        this.str = str;
        this.keyStr = keyStr;
    }
    public OperateString(String str, String keyStr, int strPos) {
        this.str = str;
        this.keyStr = keyStr;
        this.strPos = strPos;
    }
    public OperateString(String str, String keyStr, int strPos, int count) {
        this.str = str;
        this.keyStr = keyStr;
        this.strPos = strPos;
        this.count = count;
    }

    // split String
    public String cutStr() {
        boolean isMatched = Pattern.matches(keyStr, str);
        String resStr = null;
        String[] tmpStr = {};
        if(isMatched) {
            tmpStr = str.split(keyStr);
        }
        if(strPos + count <= tmpStr.length) {
            for(int i = strPos; i < tmpStr.length; i++) {
                resStr += tmpStr;
            }
        }
        return resStr;
    }
}
