// thinkinjavaex/chapter14/Ex22.java

import java.util.*;
import java.lang.reflect.*;
import static com.wyett.util.Print.*;

interface Interface {
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface {
    public void doSomething() { print("doSomething"); }
    public void somethingElse(String arg) {
        print("somethingElse " + arg);
    }
}

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;
    public DynamicProxyHandler(Object proxied){
        this.proxied = proxied;
    }
    public Object
    invoke(Object proxy, Method method, Object[] args)
    throws Throwable{
        long timeIn = new Date().getTime();
        print("**** proxy " + proxy.getClass() + 
            ", method " + method + ", args " + args +
            ", invoked at " + timeIn + " on " + (new Date()));
            
        if( args != null)
            for(Object arg : args)
                print(" " + arg);
        long timeOut = new Date().getTime();
        System.out.println("Method call-return time: " + (timeOut - timeIn) + " msecs");
        return method.invoke(proxied, args);
    }
}

class Ex22 {
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args){
        RealObject real = new RealObject();
        consumer(real);
        //
        Interface proxy = (Interface)Proxy.newProxyInstance(
            Interface.class.getClassLoader(),
            new Class[]{ Interface.class },
            new DynamicProxyHandler(real));
        consumer(proxy);
    }
}
