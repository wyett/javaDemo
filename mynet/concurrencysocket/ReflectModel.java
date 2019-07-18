package mynet.concurrencysocket;

import java.lang.reflect.Method;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/18 18:03
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class ReflectModel<T> {
//    private T className;
//    public ReflectModel(T t) {
//        this.className = t;
//    }
    public void encode(Class<T> className) throws Exception{
        Method m = className.getMethod("encrypt", String.class);
        m.invoke(className, className.getDeclaredFields());
    }
    public void decode(Class<T> className) throws Exception {
        Method m = className.getMethod("decrypt", String.class);
        m.invoke(className, className.getDeclaredFields());
    }
//    public void encode(T className) throws Exception{
//        Method m = className.getMethod("encrypt", String.class);
//        m.invoke(className, className.getDeclaredFields());
//    }
//    public void decode(T className) throws Exception{
//        Method m = className.getMethod("decrypt", String.class);
//        m.invoke(className, className.getDeclaredFields());
//    }
}
