package com.wyett.thinkinjava.sync;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/10 21:04
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class StringBufferRemoveSync {
    public void add(String str1, String str2) {
        StringBuffer sb = new StringBuffer();
        sb.append(str1).append(str2);
    }
    public static void main(String[] args){
        StringBufferRemoveSync rmsync =
                new StringBufferRemoveSync();
        for(int i = 0; i < 1000000; i++)
            rmsync.add("abc", "123");
    }
}
