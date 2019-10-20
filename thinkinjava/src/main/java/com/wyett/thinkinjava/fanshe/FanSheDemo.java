package com.wyett.thinkinjava.fanshe;
import java.lang.reflect.Method;
import java.util.ArrayList;
/**
 * @author chelei
 * @date 2019/5/29 19:29
 */
public class FanSheDemo {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("aaa");
        strList.add("bbb");

        Class listClass = strList.getClass();
        Method m = listClass.getMethod("add", Object.class);
        m.invoke(strList, 100);

        for(Object obj: strList){
            System.out.println(obj);
        }
    }
}
