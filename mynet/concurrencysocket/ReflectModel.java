package mynet.concurrencysocket;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/18 18:03
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class ReflectModel<T> {

    /** encode className's private filed */
    public void encode(T className) throws Exception{
        System.out.println("ReflectMode.encode: " + className);
        Class t  = Class.forName(className.getClass().getName());
        Field[] fieldArr = t.getSuperclass().getDeclaredFields();
        Method m = null;
        for(Field field: fieldArr){
            field.setAccessible(true);
            m = t.getMethod("encryptField", field.getType());
            m.invoke(className, field.get(className));
        }
    }
    /** decode className's private filed */
    public void decode(T className) throws Exception{
        Class t = Class.forName(className.getClass().getName());
        Field[] fieldArr = t.getSuperclass().getDeclaredFields();
        Method m = null;
        for(Field field: fieldArr){
            field.setAccessible(true);
            m = t.getMethod("decryptField", field.getType());
//            m.invoke(className, field.get(className));
            m.invoke(className, null);
        }
        System.out.println("end of ReflectMode.decode: " + className);
    }
}
